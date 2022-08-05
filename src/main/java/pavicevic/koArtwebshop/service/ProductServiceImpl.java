package pavicevic.koArtwebshop.service;

import exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.entity.ProductEntity;
import pavicevic.koArtwebshop.repository.ProductEntityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepository.findAll();
    }

    @Override
    @SneakyThrows
    public ProductEntity findById(Integer id) {
        return productEntityRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Proizvod nije nadjen"));

    }
}
