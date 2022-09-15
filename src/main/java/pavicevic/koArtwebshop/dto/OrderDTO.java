package pavicevic.koArtwebshop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pavicevic.koArtwebshop.entity.Product;
import pavicevic.koArtwebshop.entity.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDTO {


    private Integer id;


    private String token;


    private Byte status;


    private BigDecimal total;


    private String name;


    private String surname;


    private String email;


    private String mobile;


    private String address;


    private String content;


    private LocalDateTime createdAt;


    private User user;


    private String orderId;

    private Integer userId;

    private Product product;

    private Integer quantity;

    private Double price;
}
