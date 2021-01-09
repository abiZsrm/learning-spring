package experiment.jms.topic.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
@PropertySource("classpath:application.properties")
public class JMSConfig
{
   @Value("${jms.activeMQBrokerURL}")
   private String m_activeMQProviderURL; 
   
   public ConnectionFactory connectionFactory()
   {
      ActiveMQConnectionFactory amqConFac = new ActiveMQConnectionFactory(); 
      amqConFac.setBrokerURL(m_activeMQProviderURL);
      return amqConFac;
   }
   
   @Bean
   public JmsTemplate jmsTemplate(){
       JmsTemplate template = new JmsTemplate();
       template.setConnectionFactory(connectionFactory());
       template.setMessageConverter(messageConverter());
       template.setPubSubDomain(true);
       return template;
   }
   
   @Bean
   public MessageConverter messageConverter() {
       MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
       converter.setTargetType(MessageType.TEXT);
       converter.setTypeIdPropertyName("_type");
       return converter;
   }
}
