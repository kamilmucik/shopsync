package pl.estrix.shopsync.messaging.listener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.config.ActiveMQConfiguration;
import pl.estrix.shopsync.model.Customer;

@Slf4j
@Component
public class ConsumerCustomer {

    @JmsListener(destination = ActiveMQConfiguration.CUSTOMER_QUEUE)
    public void receiveCustomer(Customer customer) {
        log.info("Received Customer message: " + customer.toString());
    }
}
