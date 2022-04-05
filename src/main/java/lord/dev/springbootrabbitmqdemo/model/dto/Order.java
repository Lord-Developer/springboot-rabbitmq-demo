package lord.dev.springbootrabbitmqdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private String orderId;
    private String name;
    private int quantity;
    private double price;


    @Override
    public String toString() {
        return "\n  Order" +
                "\n{" +
                "   orderId = '" + orderId + '\'' + ",\n" +
                "   name = '" + name + '\'' + ",\n" +
                "   quantity = " + quantity + ",\n" +
                "   price = " + price +
                "\nq}";
    }
}
