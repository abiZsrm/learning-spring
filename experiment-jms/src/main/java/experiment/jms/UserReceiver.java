package experiment.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConverter;

public class UserReceiver implements MessageListener
{
   @Autowired
   private MessageConverter messageConverter;

   
   @Override
   public void onMessage(Message message)
   {
         String receivedUser = (String)messageConverter.fromMessage((org.springframework.messaging.Message<?>) message, this.getClass());
         System.out.println( ">> Received user: " + receivedUser);
   }

}
