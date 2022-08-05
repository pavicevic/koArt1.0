package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Table(name = "transaction_table")
@Entity
@Data
public class TransactionEntity extends BaseEntity{
    @Column
    private Integer status;

    @Column
    private String content_;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity orderEntity;



}
