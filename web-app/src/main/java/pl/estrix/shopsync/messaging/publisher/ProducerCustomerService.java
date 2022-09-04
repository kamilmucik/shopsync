package pl.estrix.shopsync.messaging.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.config.ActiveMQConfiguration;
import pl.estrix.shopsync.model.Customer;

@Slf4j
@Service
public class ProducerCustomerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendCustomer(String name, Integer age){
        Customer customer = new Customer(name, age);
        log.info("Sending customer message" + customer.toString() + " to queue " + ActiveMQConfiguration.CUSTOMER_QUEUE);
        jmsTemplate.convertAndSend(ActiveMQConfiguration.CUSTOMER_QUEUE, customer);
    }
}
