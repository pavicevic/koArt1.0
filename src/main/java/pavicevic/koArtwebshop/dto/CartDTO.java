package pavicevic.koArtwebshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pavicevic.koArtwebshop.entity.Product;
import pavicevic.koArtwebshop.entity.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartDTO {

    private Integer id;

    private Product product;

    private Integer quantity;

    private Double price;

    private Integer userId;

    private LocalDateTime createdAt;














}
