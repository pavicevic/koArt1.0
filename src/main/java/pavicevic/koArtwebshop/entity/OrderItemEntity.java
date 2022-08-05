package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Table(name = "order_item_table")
@Entity
@Data
public class OrderItemEntity extends BaseEntity {

    @Column
    private String sku;

    @Column
    private BigDecimal price;

    @Column
    private Double discount;

    @Column
    private Byte quantity;

    @Column
    private String content_;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity orderEntity;



}
