package pavicevic.koArtwebshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Table(name = "product_review_table")
@Entity
@Data
public class ProductReviewEntity extends BaseEntity{

    @Column
    private String title;

    @Column
    private Integer rating;

    @Column
    private Boolean published;

    @Column
    private String content_;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="published_at")
    private Date publishedAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ProductReviewEntity productReviewEntity;

}
