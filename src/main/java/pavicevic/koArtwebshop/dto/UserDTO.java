package pavicevic.koArtwebshop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {


    private Integer id;


    private String name;


    private String surname;


    private String mobile;


    private String email;


    private String passwordHash;


    private Boolean admin;


    private LocalDateTime registeredAt;


    private LocalDateTime lastLogin;


}
