package experiment.jms.Test;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import experiment.jms.StudentReceiver;
import experiment.jms.config.JMSConfig;
import experiment.jms.config.JMSConsumerConfig;

public class StudentConsumerApp
{
   public static void main(String[] args) 
      throws IOException
   {
      AbstractApplicationContext context = new AnnotationConfigApplicationContext( JMSConfig.class, JMSConsumerConfig.class );
      
      // Consume the messages (Student Objects). 
      StudentReceiver studentReceiver = context.getBean(StudentReceiver.class);
      
      // Hold the thread. 
      System.in.read();
      
      context.close();
   }
}
