package experiment.jms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import experiment.jms.StudentReceiver;

@Configuration
public class JMSConsumerConfig
{
   @Autowired
   JMSConfig jmsCommonConfig;

   @Bean
   public JmsTemplate jmsTemplate(){
       JmsTemplate jmsTemplate = new JmsTemplate();
       jmsTemplate.setConnectionFactory(jmsCommonConfig.nativeConnectionFactory());
       return  jmsTemplate;
   }

   @Bean
   public StudentReceiver studentReceiver(){
       return new StudentReceiver();
   }

   @Bean
   public DefaultMessageListenerContainer containerListener() {
       DefaultMessageListenerContainer listener = new DefaultMessageListenerContainer();
       listener.setConnectionFactory(jmsCommonConfig.nativeConnectionFactory());
       listener.setDestination(jmsCommonConfig.studentsQueue());
       listener.setMessageListener(studentReceiver());
       return listener;
   }
   
   @Bean
   public MessageConverter converter()
   {
      return new SimpleMessageConverter();
   }
}
