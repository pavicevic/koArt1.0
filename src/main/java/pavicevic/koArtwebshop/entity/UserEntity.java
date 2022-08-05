package pavicevic.koArtwebshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name="user_table")
@Entity
@Data
@ToString(exclude = "password_hash")
public class UserEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String mobile;

    @Column
    private String email;

    @Column
    private String password_hash;

    @Column
    private Boolean admin;

    @Column
    private Boolean vendor;

    @Column
    private String vendor_intro;

    @Column
    private String profile;


    @Column(name="registered_at")
    private Date registeredAt;

    @Column(name="last_login")
    private Date lastLogin;

}
