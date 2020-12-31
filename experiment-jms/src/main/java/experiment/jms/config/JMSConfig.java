package experiment.jms.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@PropertySource("classpath:jms/jms.properties")
@ComponentScan(basePackages = { "experiment.jms" })
public class JMSConfig
{
   @Value("${jms.activeMQBrokerURL}")
   private String m_activeMQBrokerUrl;

   @Bean
   public ConnectionFactory nativeConnectionFactory()
   {
      ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
      cf.setBrokerURL(m_activeMQBrokerUrl);
      cf.setTrustAllPackages(true);
      return cf;
   }

   @Bean
   public JmsTemplate jmsTemplate()
   {
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(nativeConnectionFactory());
      jmsTemplate.setDefaultDestination(studentsQueue());
      jmsTemplate.setPubSubNoLocal(false);
      return jmsTemplate;
   }

   @Bean
   public Queue studentsQueue()
   {
      return new ActiveMQQueue("queues.students");
   }
}
