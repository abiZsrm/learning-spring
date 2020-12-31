package experiment.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import experiment.jms.dto.Student;

public class StudentReceiver implements MessageListener
{
   @Autowired
   MessageConverter messageConverter; 

   @Override
   public void onMessage(Message message)
   {
      Student receivedStudent = null;
      
      try
      {
         receivedStudent = (Student) messageConverter.fromMessage(message);
         String outputMessage = "\n>>>>> Received Student: " + receivedStudent.toString() + "\n"; 
         System.out.println(outputMessage);
      }
      catch (JMSException e)
      {
         e.printStackTrace();
      }
   }

}
