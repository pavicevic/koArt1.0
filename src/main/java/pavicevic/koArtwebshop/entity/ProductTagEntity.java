package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;


@Table(name = "product_tag_table")
@Entity
@Data
public class ProductTagEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tagEntity;

}
