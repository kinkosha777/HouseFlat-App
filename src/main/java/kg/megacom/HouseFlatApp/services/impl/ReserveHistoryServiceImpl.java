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
        ReserveHistoryDto reserveHistoryDto = new ReserveHistoryDto();
        reserveHistoryDto.setStartDate(inputReserveHistoryData.getStartDate());
        reserveHistoryDto.setEndDate(inputReserveHistoryData.getEndDate());
        reserveHistoryDto.setHouse(houseService.findHouseById(inputReserveHistoryData.getHouseId()));
        reserveHistoryDto.setUser(userService.findUserById(inputReserveHistoryData.getCustomerUser()));
        reserveHistoryDto.setReserveStatus(ReserveStatus.PAID);
        Long range = ChronoUnit.DAYS.between(inputReserveHistoryData.getStartDate(), inputReserveHistoryData.getEndDate());
        System.out.println("Number of days between the start date : " + inputReserveHistoryData.getStartDate() + " and end date : " + inputReserveHistoryData.getEndDate()
                + " is  ==> " + range);

//        double totalPrice = reserveHistoryDto.getTotalPrice();
        double price = houseService.findHouseById(inputReserveHistoryData.getHouseId()).getPrice();
        double countPrice = range * price;
        reserveHistoryDto.setTotalPrice(countPrice);
        System.out.println("count"+ countPrice);




        System.out.println("asdasdsad"+reserveHistoryDto);
//        reserveHistoryDto.setTotalPrice(priceCounter(range,houseService.findHouseById(inputReserveHistoryData.getHouseId()).getPrice()));
        return reserveHistoryMapper.toDto(reserveHistoryRepo.save(reserveHistoryMapper.toEntity(reserveHistoryDto)));
    }

    @Override
    public ReserveHistoryDto findReserveById(Long id) {
        ReserveHistory reserveHistory = reserveHistoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Айди заказа не найден!"));
        return reserveHistoryMapper.toDto(reserveHistory);
    }

    @Override
    public OutputReserveData doOperation(List<ReserveHistoryDto> reserveHistoryDtoList, Long id) {
        OutputReserveData outputReserveData = new OutputReserveData();
    Period days = outputReserveData.getStartDate().until(outputReserveData.getEndDate());
        System.out.println("+asdasd"+days);
        return null;
    }

    @Override
    public OutputReserveData pay(Long user_id, double cash) {
        if (cash<=0){
            throw new RuntimeException("Оплата не произошла!");
        }
        UserDto userDto = userService.findUserById(user_id);

        PayHistoryDto payHistoryDto = new PayHistoryDto();
        ReserveHistoryDto reserveHistoryDto = new ReserveHistoryDto();
        reserveHistoryDto.setUser(userDto);

        if (reserveHistoryDto.getReserveStatus().equals(ReserveStatus.RESERVED) || reserveHistoryDto.getReserveStatus().equals(ReserveStatus.CANCELLED))
         payHistoryDto.setCash(payHistoryDto.getCash()+cash);
        if (payHistoryDto.getCash()>=reserveHistoryDto.getTotalPrice()){
            reserveHistoryDto.setReserveStatus(ReserveStatus.PAID);
            reserveHistoryDto.setTotalPrice(reserveHistoryDto.getTotalPrice()- payHistoryDto.getCash());
        }
        reserveHistoryDto = saveReserve(reserveHistoryDto);
        payHistoryDto.setReserveHistory(reserveHistoryDto);
        PayHistoryDto payHistoryDtoSaved = payHistoryService.savePay(payHistoryDto);

        return null;
    }


}
