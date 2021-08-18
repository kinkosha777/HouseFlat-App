package kg.megacom.HouseFlatApp.models.inputs;

import lombok.Data;
@Data
public class InputHouseData {
    private int room;
    private String description;
    private int floor;
    private double area;
    private double price;
    private Long typeId;
    private String internet;
    private String furniture;
    private Long ownerUserId;
    private Long cityVillageId;
    private Long districtId;
    private double lat;
    private double lon;
    private String address;
}
