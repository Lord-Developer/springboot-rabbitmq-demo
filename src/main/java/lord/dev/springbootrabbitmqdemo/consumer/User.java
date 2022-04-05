package lord.dev.springbootrabbitmqdemo.consumer;

import lord.dev.springbootrabbitmqdemo.config.RabbitMQConfig;
import lord.dev.springbootrabbitmqdemo.model.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from queue : " + orderStatus);
    }
}
