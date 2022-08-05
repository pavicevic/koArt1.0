package pavicevic.koArtwebshop.controller.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Slf4j
@Data
public class FinishOrderItemRequest {

    private Map<Integer,Integer> ProductIdProductQuantity;

    @NotEmpty
    private String name ;
    private String surname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    private String comment;
}
