package pavicevic.koArtwebshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.dto.CartDTO;
import pavicevic.koArtwebshop.dto.ProductCartDTO;
import pavicevic.koArtwebshop.entity.Cart;
import pavicevic.koArtwebshop.entity.ProductCart;
import pavicevic.koArtwebshop.mapper.CartMapper;
import pavicevic.koArtwebshop.mapper.ProductCartMapper;
import pavicevic.koArtwebshop.repository.CartRepository;
import pavicevic.koArtwebshop.repository.ProductCartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductCartRepository productCartRepository;

    @Autowired
    private ProductCartMapper productCartMapper;

    public void addCart(CartDTO cartDTO){
        Cart cart= cartMapper.convertToEntity(cartDTO);
        cartRepository.save(cart);
    }
    public CartDTO findCartById(Integer id){
        Cart cart= cartRepository.findCartById(id);
        return cartMapper.convertToDTO(cart);
    }
    public Cart updateCart(Cart cart){
        return cartRepository.save(cart);
    }
    public void deleteCart(Integer userId){
        cartRepository.deleteByUserId(userId);
    }

    public CartDTO findCartByUserId(Integer userId) {
        Cart cart=cartRepository.findCartByUserId(userId);
        return cartMapper.convertToDTO(cart);
    }
    public void addProductToCart(ProductCartDTO productCartDTO){
        ProductCart productCart= productCartMapper.convertToEntity(productCartDTO);
        productCartRepository.save(productCart);
    }
}
