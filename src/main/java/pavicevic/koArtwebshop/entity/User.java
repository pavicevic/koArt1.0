package pavicevic.koArtwebshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Table(name="user_table")
@Entity
@Getter
@Setter
//@ToString(exclude = "password_hash")
@ToString
public class User implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String token;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String mobile;

    @Column
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column
    private Boolean admin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @CreationTimestamp
    @Column(name="registered_at")
    private LocalDateTime registeredAt;



}
