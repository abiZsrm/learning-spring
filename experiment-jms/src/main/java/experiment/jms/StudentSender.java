package experiment.jms;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import experiment.jms.dto.Student;

@Component
public class StudentSender
{
   @Autowired
   JmsTemplate jmsTemplate;

   public void sendMessage(final Student student)
   {
      jmsTemplate.send((Session session) -> session.createObjectMessage(student));
   }
}