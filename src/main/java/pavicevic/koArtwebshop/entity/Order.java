package pavicevic.koArtwebshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "order_table")
@Entity
@Data
public class Order implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String token;

    @Column
    private Byte status;

    @Column
    private BigDecimal total;

    @Column(name = "name_")
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String mobile;

    @Column
    private String address;

    @Column(name = "content_")
    private String content;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_id")
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @CreationTimestamp
    @Column(name="created_at",updatable=false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
        Product product;
        Integer quantity;
        Double price;



}
