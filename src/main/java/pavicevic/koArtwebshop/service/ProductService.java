package pavicevic.koArtwebshop.service;

import pavicevic.koArtwebshop.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAll();

    ProductEntity findById(Integer id);
}
