package pavicevic.koArtwebshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pavicevic.koArtwebshop.entity.Category;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductDTO {

    private Integer id;


    private String title;


    private String summary;


    private Category category;


    private BigDecimal price;


    private Integer quantity;


    private Boolean available;


    private String content_;


    private LocalDateTime createdAt;


    private Integer category_id;




}
