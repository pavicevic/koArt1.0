package pavicevic.koArtwebshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.controller.dto.FinishOrderItemRequest;
import pavicevic.koArtwebshop.entity.ProductEntity;

@Service
@AllArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final ProductService productService;

    @Override
    public Integer finishOrderItem(FinishOrderItemRequest request) {
        request.getProductIdProductQuantity().forEach((k,v)->{
            ProductEntity productEntity= productService.findById(k);
            
        });
        return null;
    }
}
