package experiment.jms.topic.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import experiment.jms.topic.dto.Exam;

@Component
public class JMSTopicSubscriber
{
   @JmsListener(destination = "${jms.enrol.topic.name}")
   public void receiveMessage(Exam exam)
   {
      System.out.println("Received message: " + exam.toString());
   }
}
