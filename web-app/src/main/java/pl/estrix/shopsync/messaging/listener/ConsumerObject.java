package pl.estrix.shopsync.messaging.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.config.ActiveMQConfiguration;
import pl.estrix.shopsync.model.CustomClass;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Slf4j
@Component
public class ConsumerObject {

    @JmsListener(destination = ActiveMQConfiguration.OBJECT_QUEUE)
    public void receiveObjectMessage(ObjectMessage objectMessage) throws JMSException {
        log.info("Receive object message: " + ((CustomClass)objectMessage.getObject()).toString());
    }

}