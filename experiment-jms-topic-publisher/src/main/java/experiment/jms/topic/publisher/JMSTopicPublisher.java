package experiment.jms.topic.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import experiment.jms.topic.dto.Exam;

@Component
public class JMSTopicPublisher
{
   @Autowired
   private JmsTemplate m_jmsTemplate; 
   
   public void send(Exam exam)
   {
      m_jmsTemplate.convertAndSend("allexams", exam);
   }
}
