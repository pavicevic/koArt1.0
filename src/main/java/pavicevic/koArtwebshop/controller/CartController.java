package pavicevic.koArtwebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pavicevic.koArtwebshop.dto.CartDTO;
import pavicevic.koArtwebshop.dto.CategoryDTO;
import pavicevic.koArtwebshop.dto.ProductCartDTO;
import pavicevic.koArtwebshop.entity.Category;
import pavicevic.koArtwebshop.repository.CartRepository;
import pavicevic.koArtwebshop.service.CartService;
import pavicevic.koArtwebshop.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @GetMapping(value="api/cart/{id}")
    public ResponseEntity<CartDTO> findCartById(@PathVariable("id") Integer id){
        CartDTO cartDTO= cartService.findCartById(id);
        return new ResponseEntity<>(cartDTO, HttpStatus.OK);
    }
    @GetMapping(value="api/cart/user/{userId}")
    public ResponseEntity<CartDTO> findCartByUserId(@PathVariable("userId")Integer userId){
        CartDTO cartDTO = cartService.findCartByUserId(userId);
        return new ResponseEntity<>(cartDTO,HttpStatus.OK);
    }
    @PostMapping(value = "api/cart/add")
    public ResponseEntity<Void> createCart(@RequestBody CartDTO cartDTO){
        cartService.addCart(cartDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "api/cart/add-product")
    public ResponseEntity<Void> addProductToCart(@RequestBody ProductCartDTO productCartDTO){
        cartService.addProductToCart(productCartDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
