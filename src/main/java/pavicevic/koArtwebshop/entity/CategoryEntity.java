package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "category_table")
@Entity
@Data
public class CategoryEntity extends BaseEntity {

    @Column
    private String title;

    @Column
    private String content_;


    @ManyToOne
    @JoinColumn(name="parent_id")
    private CategoryEntity categoryEntity;
}
