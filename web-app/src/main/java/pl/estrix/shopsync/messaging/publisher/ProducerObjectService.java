package pl.estrix.shopsync.messaging.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.config.ActiveMQConfiguration;
import pl.estrix.shopsync.model.CustomClass;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Slf4j
@Service
public class ProducerObjectService {


    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendObject(String value){
        log.info("Send object message with value " + value + " to queue " + ActiveMQConfiguration.OBJECT_QUEUE);
        jmsTemplate.send(ActiveMQConfiguration.OBJECT_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(new CustomClass(value));
                return objectMessage;
            }
        });
    }

}