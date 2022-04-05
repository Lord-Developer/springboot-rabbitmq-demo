package lord.dev.springbootrabbitmqdemo.publisher;

import lord.dev.springbootrabbitmqdemo.config.RabbitMQConfig;
import lord.dev.springbootrabbitmqdemo.model.dto.Order;
import lord.dev.springbootrabbitmqdemo.model.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/order")
public class OrderPublisher {

    private final RabbitTemplate template;

    @Autowired
    public OrderPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        //restaurant service
        //payment service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in " + restaurantName);
        template.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}