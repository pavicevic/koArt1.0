package pavicevic.koArtwebshop.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pavicevic.koArtwebshop.entity.ProductEntity;
import pavicevic.koArtwebshop.service.ProductService;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductEntity> getAllProducts(){
        log.info("handling get all products request");
        return productService.findAll();

    }

    @GetMapping("/product/{id}")
    public ProductEntity findById(@PathVariable Integer id){
        log.info("handling get products by id");
        return productService.findById(id);
    }

}
