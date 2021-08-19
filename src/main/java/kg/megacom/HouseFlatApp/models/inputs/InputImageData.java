package kg.megacom.HouseFlatApp.models.inputs;

import lombok.Data;

@Data
public class InputImageData {
    private Long houseId;
    private String url;
    private int orderNum;
}
