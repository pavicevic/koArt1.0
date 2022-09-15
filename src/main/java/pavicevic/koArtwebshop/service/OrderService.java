package pavicevic.koArtwebshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.dto.OrderDTO;
import pavicevic.koArtwebshop.entity.Order;
import pavicevic.koArtwebshop.mapper.OrderMapper;
import pavicevic.koArtwebshop.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;


//    public void addOrder(OrderDTO orderDTO){
//        Order order= orderMapper.convertToEntity(orderDTO);
//        orderDTO.set
//        orderRepository.save(order);
//
//    }
}
