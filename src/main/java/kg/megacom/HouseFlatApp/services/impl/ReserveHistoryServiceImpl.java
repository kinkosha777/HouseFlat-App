package kg.megacom.HouseFlatApp.services.impl;

import kg.megacom.HouseFlatApp.dao.ReserveHistoryRepo;
import kg.megacom.HouseFlatApp.enums.ReserveStatus;
import kg.megacom.HouseFlatApp.exceptions.DateAlreadyReserve;
import kg.megacom.HouseFlatApp.exceptions.PaymentFailed;
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
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
            throw new DateAlreadyReserve("Даты зарезирвированы!");
        }
        ReserveHistoryDto reserveHistoryDto = new ReserveHistoryDto();
        reserveHistoryDto.setStartDate(inputReserveHistoryData.getStartDate());
        reserveHistoryDto.setEndDate(inputReserveHistoryData.getEndDate());
        reserveHistoryDto.setHouse(houseService.findHouseById(inputReserveHistoryData.getHouseId()));
        reserveHistoryDto.setUser(userService.findById(inputReserveHistoryData.getCustomerUser()));
        reserveHistoryDto.setReserveStatus(ReserveStatus.RESERVED);
        Long range = ChronoUnit.DAYS.between(inputReserveHistoryData.getStartDate(), inputReserveHistoryData.getEndDate());
        System.out.println("Number of days between the start date : " + inputReserveHistoryData.getStartDate() + " and end date : " + inputReserveHistoryData.getEndDate()
                + " is  ==> " + range);

        double totalPrice = reserveHistoryDto.getTotalPrice();
        double price = houseService.findHouseById(inputReserveHistoryData.getHouseId()).getPrice();
        double countPrice = range * price;
        reserveHistoryDto.setTotalPrice(countPrice);
        System.out.println("count"+ countPrice);
//        if (reserveHistoryDto.getEndDate().isBefore(reserveHistoryDto.getStartDate()) || reserveHistoryDto.getStartDate().isEqual(reserveHistoryDto.getEndDate())){
//            throw new RuntimeException("Даты не правильно!");
//        }

        System.out.println("asdasdsad"+reserveHistoryDto);
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
            throw new PaymentFailed("Оплата не произошла!");
        }


        UserDto userDto = userService.findById(user_id);
        PayHistoryDto payHistoryDto = new PayHistoryDto();
        ReserveHistoryDto reserveHistoryDto = findReserveById(reserve_id);
        reserveHistoryDto.setUser(userDto);
//        System.out.println("dno"+reserveHistoryDto);
        userDto.setPhone(userDto.getPhone());

        reserveHistoryDto.setReserveStatus(ReserveStatus.RESERVED);
//        System.out.println("beka"+reserveHistoryDto.getReserveStatus());

        double totalPrice = reserveHistoryDto.getTotalPrice();
        List<PayHistoryDto> payHistoryDtos = payHistoryService.findByReserveHistoryId(reserve_id);

        if (payHistoryDtos == null){
            payHistoryDto.setCash(cash);
        }else {
            double moneyPaidBefore = payHistoryDtos.stream().mapToDouble(PayHistoryDto::getCash).sum();
            payHistoryDto.setCash(cash);
            if (moneyPaidBefore + payHistoryDto.getCash()>=totalPrice){
                reserveHistoryDto.setReserveStatus(ReserveStatus.PAID);
            }
        }

        reserveHistoryDto = saveReserve(reserveHistoryDto);
        payHistoryDto.setReserveHistory(reserveHistoryDto);
        PayHistoryDto payHistoryDtoSaved = payHistoryService.savePay(payHistoryDto);

        OutputReserveData outputReserveData = new OutputReserveData();
        outputReserveData.setCash(payHistoryDtoSaved.getCash()- outputReserveData.getTotalPrice());
        outputReserveData.setCustomerId(reserveHistoryDto.getUser().getId());
        outputReserveData.setTotalPrice(reserveHistoryDto.getTotalPrice() - cash);
        outputReserveData.setReserveStatus(reserveHistoryDto.getReserveStatus());
        outputReserveData.setReserveId(reserve_id);
        outputReserveData.setHouseId(reserveHistoryDto.getHouse().getId());
        outputReserveData.setStartDate(reserveHistoryDto.getStartDate());
        outputReserveData.setEndDate(reserveHistoryDto.getEndDate());
        System.out.println("emae"+outputReserveData);

        return toOutputReserveHistory(reserveHistoryDto,cash);

    }
    public OutputReserveData toOutputReserveHistory(ReserveHistoryDto reserveHistoryDto, double cash){
        OutputReserveData outputReserveData = new OutputReserveData();
        outputReserveData.setReserveStatus(reserveHistoryDto.getReserveStatus());
        outputReserveData.setCustomerId(reserveHistoryDto.getUser().getId());
        outputReserveData.setStartDate(reserveHistoryDto.getStartDate());
        outputReserveData.setEndDate(reserveHistoryDto.getEndDate());
        outputReserveData.setTotalPrice(reserveHistoryDto.getTotalPrice());
        outputReserveData.setCash(cash);
        outputReserveData.setHouseId(reserveHistoryDto.getHouse().getId());
        return outputReserveData;
    }

    @Override
    public List<ReserveHistoryDto> findHouseById(Long id) {
        return reserveHistoryMapper.toDtoList(reserveHistoryRepo.findByHouseId(id));
    }
}
