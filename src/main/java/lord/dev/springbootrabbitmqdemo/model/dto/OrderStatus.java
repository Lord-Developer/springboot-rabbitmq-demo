package lord.dev.springbootrabbitmqdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderStatus {

    private Order order;
    private String status;
    private String message;

    @Override
    public String toString() {
        return " \nOrderStatus" +
                "\n{" +
                "\n   order = " + order + ",\n" +
                "   status = '" + status + '\'' + "\n" +
                "   message = '" + message + '\'' + "\n"+
                '}';
    }
}
