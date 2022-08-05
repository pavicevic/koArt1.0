package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "cart_table")
@Entity
@Data
public class CartEntity extends BaseEntity {

    @Column
    private String session_id;

    @Column
    private String token;

    @Column
    private Integer status;

    @Column
    private String name_;

    @Column
    private String surname;

    @Column
    private String mobile;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String content_;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;



    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;
}
