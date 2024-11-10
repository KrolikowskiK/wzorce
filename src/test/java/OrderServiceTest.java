import static org.junit.jupiter.api.Assertions.*;

import com.example.authenticator.method.PasswordAuthenticator;
import com.example.item.Item;
import com.example.item.Product;
import com.example.order.creator.Order;
import com.example.order.delivery.method.DpdDelivery;
import com.example.order.service.OrderService;
import com.example.payment.method.PaypalPayment;
import com.example.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OrderServiceTest {
    private OrderService orderService;
    private Order order;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
        User user = new User("Test", new PasswordAuthenticator());
        List<Item> items = new ArrayList<>();
        items.add(new Product("test"));
        order = new Order(user, items);
        order.setPaymentStrategy(new PaypalPayment());
        order.setDeliverer(new DpdDelivery());
    }

    @Test
    void testPlaceOrderSuccess() {
        assertDoesNotThrow(() -> orderService.processOrder(order, amount -> 10));
    }

    @Test
    void testCancelOrderSuccess() {
        assertDoesNotThrow(() -> orderService.cancelOrder("1234"));
    }

    @Test
    void testTrackOrderSuccess() {
        assertDoesNotThrow(() -> orderService.trackOrder("1234"));
    }

    @Test
    void testReturnOrderInvalidOrderId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> orderService.returnOrder(null));
        assertEquals("Order ID cannot be null", exception.getMessage());
    }

    @Test
    void testCancelOrderNotExists() {
        Exception exception = assertThrows(IllegalStateException.class, () -> orderService.cancelOrder("9999"));
        assertEquals("Order not found", exception.getMessage());
    }
}
