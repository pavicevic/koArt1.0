package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;


@Table(name = "product_meta_table")
@Entity
@Data
public class ProductMetaEntity extends BaseEntity {

    @Column
    private String key_;

    @Column
    private String content_;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

}
