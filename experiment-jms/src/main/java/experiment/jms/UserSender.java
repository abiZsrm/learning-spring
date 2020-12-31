package experiment.jms;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserSender
{
   @Autowired
   JmsTemplate jmsTemplate;

   public void sendMessage(final String message)
   {
      jmsTemplate.send((Session session) -> session.createObjectMessage(message));
   }
}