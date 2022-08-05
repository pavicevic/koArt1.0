package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "cart_item_table")
@Entity
@Data
public class CartItemEntity extends BaseEntity{

    @Column
    private Double price;

    @Column
    private Double discount;

    @Column
    private Integer quantity;

    @Column
    private Boolean active;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;

    @Column
    private String content_;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private CartEntity cartEntity;
}
