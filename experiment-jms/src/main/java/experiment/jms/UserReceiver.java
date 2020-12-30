package experiment.jms;

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
      // TODO Auto-generated method stub
      
   }

}
