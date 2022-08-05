package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


@Table(name = "order_table")
@Entity
@Data
public class OrderEntity extends BaseEntity {

    @Column
    private String session_id;

    @Column
    private String token;

    @Column
    private Byte status;

    @Column
    private BigDecimal sub_total;

    @Column
    private Double item_discount;

    @Column
    private BigDecimal shipping;

    @Column
    private BigDecimal total;

    @Column
    private Double discount;

    @Column
    private BigDecimal grand_total;

    @Column
    private String name_;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String content_;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;
}
