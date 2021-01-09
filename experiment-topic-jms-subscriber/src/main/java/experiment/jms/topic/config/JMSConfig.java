package experiment.jms.topic.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
@PropertySource("classpath:application.properties")
public class JMSConfig
{
   @Value("${spring.activemq.broker-url}")
   String m_activeMQBrokerUrl;

   @Bean
   public ConnectionFactory connectionFactory()
   {
      ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
      cf.setBrokerURL(m_activeMQBrokerUrl);
      return cf;
   }

   @Bean
   public JmsListenerContainerFactory<?> jmsListenerContainerFactory()
   {
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      factory.setPubSubDomain(true);
      factory.setMessageConverter(messageConverter());
      factory.setConnectionFactory(connectionFactory());
      return factory;
   }

   @Bean
   public MessageConverter messageConverter()
   {
      MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
      converter.setTargetType(MessageType.TEXT);
      converter.setTypeIdPropertyName("_type");
      return converter;
   }
}
