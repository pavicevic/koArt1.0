package pavicevic.koArtwebshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pavicevic.koArtwebshop.entity.Cart;
import pavicevic.koArtwebshop.entity.Product;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductCartDTO {

   public Integer id;


    public Cart cart;


    public Product product;


    public Integer quantity;
}
