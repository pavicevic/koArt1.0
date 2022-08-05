package pavicevic.koArtwebshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pavicevic.koArtwebshop.controller.dto.FinishOrderItemRequest;

import javax.validation.Valid;

@RestController
@Slf4j
public class OrderItemController {

    @PostMapping("/api/finishOrderItem")
    public ResponseEntity finishOrderItem(@Valid @RequestBody FinishOrderItemRequest request){
        log.info("handling finish order item request:{}",request);
        return ResponseEntity.ok().build();
    }
}
