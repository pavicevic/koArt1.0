package pavicevic.koArtwebshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Table(name = "tag_table")
@Entity
@Data
public class TagEntity extends BaseEntity{

    @Column
    private String title;

    @Column
    private String content_;

}
