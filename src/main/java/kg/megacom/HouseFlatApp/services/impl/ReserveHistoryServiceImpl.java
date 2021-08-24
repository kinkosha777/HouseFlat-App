package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.ReserveHistoryRepo;
import kg.megacom.HouseFlatApp.enums.ReserveStatus;
import kg.megacom.HouseFlatApp.mappers.ReserveHistoryMapper;
import kg.megacom.HouseFlatApp.models.dto.PayHistoryDto;
import kg.megacom.HouseFlatApp.models.dto.ReserveHistoryDto;
import kg.megacom.HouseFlatApp.models.dto.UserDto;
import kg.megacom.HouseFlatApp.models.entities.ReserveHistory;
import kg.megacom.HouseFlatApp.models.inputs.InputReserveHistoryData;
import kg.megacom.HouseFlatApp.models.outputs.OutputReserveData;
import kg.megacom.HouseFlatApp.services.HouseService;
import kg.megacom.HouseFlatApp.services.PayHistoryService;
import kg.megacom.HouseFlatApp.services.ReserveHistoryService;
import kg.megacom.HouseFlatApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReserveHistoryServiceImpl implements ReserveHistoryService {

    @Autowired
    private ReserveHistoryRepo reserveHistoryRepo;
    @Autowired
    private HouseService houseService;
    @Autowired
    private UserService userService;
    @Autowired
    private PayHistoryService payHistoryService;

    ReserveHistoryMapper reserveHistoryMapper = ReserveHistoryMapper.RESERVE_HISTORY_MAPPER;

    @Override
    public ReserveHistoryDto saveReserve(ReserveHistoryDto reserveHistoryDto) {
        return reserveHistoryMapper.toDto(reserveHistoryRepo.save(reserveHistoryMapper.toEntity(reserveHistoryDto)));
    }

    @Override
    public ReserveHistoryDto save(InputReserveHistoryData inputReserveHistoryData) {
        List<ReserveHistoryDto> historyDtoList = reserveHistoryMapper.toDtoList(reserveHistoryRepo.findByHouseId(inputReserveHistoryData.getHouseId()));
        if (checkDate(historyDtoList,inputReserveHistoryData.getStartDate(),inputReserveHistoryData.getEndDate())){
            throw new RuntimeException("Не  работает!");
        }


        ReserveHistoryDto reserveHistoryDto = new ReserveHistoryDto();
        reserveHistoryDto.setStartDate(inputReserveHistoryData.getStartDate());
        reserveHistoryDto.setEndDate(inputReserveHistoryData.getEndDate());
        reserveHistoryDto.setHouse(houseService.findHouseById(inputReserveHistoryData.getHouseId()));
        reserveHistoryDto.setUser(userService.findUserById(inputReserveHistoryData.getCustomerUser()));
        reserveHistoryDto.setReserveStatus(ReserveStatus.RESERVED);
        Long range = ChronoUnit.DAYS.between(inputReserveHistoryData.getStartDate(), inputReserveHistoryData.getEndDate());
        System.out.println("Number of days between the start date : " + inputReserveHistoryData.getStartDate() + " and end date : " + inputReserveHistoryData.getEndDate()
                + " is  ==> " + range);

        double totalPrice = reserveHistoryDto.getTotalPrice();
        double price = houseService.findHouseById(inputReserveHistoryData.getHouseId()).getPrice();
        double countPrice = range * price;
        reserveHistoryDto.setTotalPrice(countPrice);
        System.out.println("count"+ countPrice);
        if (reserveHistoryDto.getEndDate().isBefore(reserveHistoryDto.getStartDate()) || reserveHistoryDto.getStartDate().isEqual(reserveHistoryDto.getEndDate())){
            throw new RuntimeException("Даты не правильно!");
        }



        System.out.println("asdasdsad"+reserveHistoryDto);
//        reserveHistoryDto.setTotalPrice(priceCounter(range,houseService.findHouseById(inputReserveHistoryData.getHouseId()).getPrice()));
        return reserveHistoryMapper.toDto(reserveHistoryRepo.save(reserveHistoryMapper.toEntity(reserveHistoryDto)));
    }
    private boolean checkDate(List<ReserveHistoryDto> reserveHistoryDtoList, LocalDate startDate, LocalDate endDate) {
        return reserveHistoryDtoList.stream().anyMatch(x->
                (x.getStartDate().isEqual(startDate) || x.getEndDate().isEqual(endDate))
                        ||
                        (x.getStartDate().isBefore(startDate) && x.getEndDate().isAfter(endDate))
                        ||
                        (x.getStartDate().isAfter(startDate)&& x.getEditDate().isBefore(endDate))
        );
    }

    @Override
    public ReserveHistoryDto findReserveById(Long id) {
        ReserveHistory reserveHistory = reserveHistoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Айди заказа не найден!"));
        return reserveHistoryMapper.toDto(reserveHistory);
    }



    @Override
    public OutputReserveData pay(Long reserve_id, Long user_id, double cash) {
        if (cash<=0){
            throw new RuntimeException("Оплата не произошла!");
        }
//        List<PayHistoryDto> payHistoryDtoList = null;
//        double totalPayedSum = payHistoryDtoList.stream().mapToDouble(PayHistoryDto::getCash).sum();
        UserDto userDto = userService.findUserById(user_id);
        PayHistoryDto payHistoryDto = new PayHistoryDto();
        ReserveHistoryDto reserveHistoryDto = findReserveById(reserve_id);
        reserveHistoryDto.setUser(userDto);
        userDto.setPhone(userDto.getPhone());


        reserveHistoryDto.setReserveStatus(ReserveStatus.RESERVED);
        System.out.println("beka"+reserveHistoryDto.getReserveStatus());

        if (reserveHistoryDto.getReserveStatus().equals(ReserveStatus.RESERVED))
         payHistoryDto.setCash(payHistoryDto.getCash()+cash);

        if (payHistoryDto.getCash()>=reserveHistoryDto.getTotalPrice()){
            reserveHistoryDto.setReserveStatus(ReserveStatus.PAID);
            reserveHistoryDto.setTotalPrice(payHistoryDto.getCash() - reserveHistoryDto.getTotalPrice());
        }
//        if (payHistoryDto.getCash()<reserveHistoryDto.getTotalPrice())
//            reserveHistoryDto.setReserveStatus(ReserveStatus.CANCELLED);

        reserveHistoryDto = saveReserve(reserveHistoryDto);
        payHistoryDto.setReserveHistory(reserveHistoryDto);
        PayHistoryDto payHistoryDtoSaved = payHistoryService.savePay(payHistoryDto);

        OutputReserveData outputReserveData = new OutputReserveData();
        outputReserveData.setCash(payHistoryDtoSaved.getCash()- outputReserveData.getTotalPrice());
        outputReserveData.setCustomerId(reserveHistoryDto.getUser().getId());
        outputReserveData.setTotalPrice(reserveHistoryDto.getTotalPrice());
        outputReserveData.setReserveStatus(reserveHistoryDto.getReserveStatus());
        outputReserveData.setReserveId(reserveHistoryDto.getId());
        outputReserveData.setHouseId(reserveHistoryDto.getHouse().getId());
        outputReserveData.setStartDate(reserveHistoryDto.getStartDate());
        outputReserveData.setEndDate(reserveHistoryDto.getEndDate());
        System.out.println("emae"+outputReserveData);

        return outputReserveData;
    }

    @Override
    public List<ReserveHistoryDto> findHouseById(Long id) {

        return reserveHistoryMapper.toDtoList(reserveHistoryRepo.findByHouseId(id));
    }

//    @Override
//    public List<ReserveHistoryDto> findPhoneByUserId(Long id, String phone) {
//        ReserveHistory reserveHistory = (ReserveHistory) reserveHistoryRepo.findPhoneByUserId(id,phone);
//        return reserveHistoryMapper.toDtoList((List<ReserveHistory>) reserveHistory);
//    }


}
