package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;


@Table(name = "product_category_table")
@Entity
@Data
public class ProductCategoryEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryEntity categoryEntity;
}
