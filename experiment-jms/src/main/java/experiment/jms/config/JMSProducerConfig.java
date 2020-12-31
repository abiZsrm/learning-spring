package experiment.jms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JMSProducerConfig
{
   @Autowired
   JMSConfig jmsCommonConfig;

   @Bean
   public JmsTemplate jmsTemplate()
   {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(jmsCommonConfig.nativeConnectionFactory());
      jmsTemplate.setDefaultDestination(jmsCommonConfig.studentsQueue());
      return jmsTemplate;
   }
}
