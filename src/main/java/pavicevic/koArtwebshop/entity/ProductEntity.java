package pavicevic.koArtwebshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "product_table")
@Entity
@Data
public class ProductEntity extends BaseEntity {

    @Column
    private String title;

    @Column
    private Integer type_;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @Column
    private Double discount;

    @Column
    private Boolean available;

    @Column
    private String content_;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="published_at")
    private Date publishedAt;

    @Column(name="starts_at")
    private Date startsAt;

    @Column(name="ends_at")
    private Date endsAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;
}
