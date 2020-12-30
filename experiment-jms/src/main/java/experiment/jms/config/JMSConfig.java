package experiment.jms.config;

import java.util.ArrayList;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;

import experiment.jms.UserReceiver;

@Configuration
@PropertySource("classpath:jms/jms.properties")
public class JMSConfig
{
   @Value("${jms.activeMQBrokerURL}")
   private String m_activeMQBrokerUrl; 
   
   @Value("${jms.activeMQConfirmation}")
   private String m_activeMQConfirmation; 
   
   @Value("${jms.username}")
   private String m_userName; 
   
   @Value("${jms.password}")
   private String m_password; 
   
   List<String> packagesList = new ArrayList<String>();

   @Bean
   public ConnectionFactory nativeConnectionFactory()
   {
      ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
      cf.setBrokerURL(m_activeMQBrokerUrl);
//      cf.setUserName(m_userName);
//      cf.setPassword(m_password);
//      cf.setTrustedPackages(packagesList);
      // or or general and unsafe
      cf.setTrustAllPackages(true);
      return cf;
   }

   @Bean
   public ActiveMQQueue confirmationQueue()
   {
      return new ActiveMQQueue(m_activeMQConfirmation);
   }

   @Bean
   public JmsTemplate jmsTemplate()
   {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(nativeConnectionFactory());
      jmsTemplate.setDefaultDestination(confirmationQueue());
      jmsTemplate.setPubSubNoLocal(false);
      return jmsTemplate;
   }

   @Bean
   public UserReceiver userReceiver()
   {
      return new UserReceiver();
   }

   @Bean
   public Queue userQueue(){
   return new ActiveMQQueue("queues.users");
   }
   
   @Bean
   public DefaultMessageListenerContainer containerListener()
   {
      DefaultMessageListenerContainer listener = new DefaultMessageListenerContainer();
      listener.setConnectionFactory(nativeConnectionFactory());
      listener.setDestination(userQueue());
      listener.setMessageListener(userReceiver());
      return listener;
   }
   
   @Bean
   public MessageConverter converter() {
   return new SimpleMessageConverter();
   }
}
