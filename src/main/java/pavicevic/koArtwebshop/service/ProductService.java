package pavicevic.koArtwebshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.dto.ProductDTO;
import pavicevic.koArtwebshop.entity.Product;
import pavicevic.koArtwebshop.entity.User;
import pavicevic.koArtwebshop.exception.ProductNotFoundException;
import pavicevic.koArtwebshop.exception.UserNotFoundException;
import pavicevic.koArtwebshop.mapper.ProductMapper;
import pavicevic.koArtwebshop.repository.CategoryRepository;
import pavicevic.koArtwebshop.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryRepository categoryRepository;




    public void addProduct(ProductDTO productDTO){
        productDTO.setCreatedAt(LocalDateTime.now());
        Product product= productMapper.convertToEntity(productDTO);




        productRepository.save(product);
    }

    public ProductDTO findProductByTitle(String title){
        Product product= productRepository.findProductByTitle(title);

        return productMapper.convertToDTO(product);

    }


    public ProductDTO findProductById(Integer id){
        Product product= productRepository.findProductById(id)
                .orElseThrow(()->new ProductNotFoundException("Product by id"+ id + "was not found"));
        return productMapper.convertToDTO(product);
    }

//    public List<Product> findProductByTitleSummary(String title,String summary){
//        return productRepository.findProductByTitleOrSummary(title,summary);
//    }

    public List<Product> findAllProducts(){

        return productRepository.findAll();
    }


    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}


