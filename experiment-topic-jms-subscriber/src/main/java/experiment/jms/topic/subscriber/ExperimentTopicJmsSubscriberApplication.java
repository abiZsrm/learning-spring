package experiment.jms.topic.subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"experiment.jms"})
public class ExperimentTopicJmsSubscriberApplication
{
   public static void main(String[] args)
   {
      SpringApplication.run(ExperimentTopicJmsSubscriberApplication.class, args);
   }
}
