package pavicevic.koArtwebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pavicevic.koArtwebshop.dto.ProductDTO;
import pavicevic.koArtwebshop.entity.Product;
import pavicevic.koArtwebshop.entity.User;
import pavicevic.koArtwebshop.repository.ProductRepository;
import pavicevic.koArtwebshop.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;
    //Get all products
    @GetMapping(value = "api/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //Create Product
    @PostMapping(value = "api/products/add")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Get product by id
    @GetMapping(value = "products/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable("id") Integer id) {
        ProductDTO productDTO = productService.findProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    //Update product
    @PutMapping(value = "api/products/update")

    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }
    //Delete product
    @DeleteMapping(value = "api/products/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
//    @GetMapping(value = "products/")
//    public  ResponseEntity<List<Product>>searchProduct(PathVariable("query")String query){
//        return new ResponseEntity<>(productRepository.findByCategoryTitleContainingOrTitleContainingOrSummaryContaining(query),HttpStatus.OK)
//    }
    }
}
