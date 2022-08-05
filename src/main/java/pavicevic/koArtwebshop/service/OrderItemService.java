package pavicevic.koArtwebshop.service;


import pavicevic.koArtwebshop.controller.dto.FinishOrderItemRequest;

public interface OrderItemService {
    Integer finishOrderItem(FinishOrderItemRequest request);
}
