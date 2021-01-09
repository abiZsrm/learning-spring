package experiment.jms.topic.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import experiment.jms.topic.dto.Exam;

@SpringBootApplication
@ComponentScan(basePackages = { "experiment.jms"})
public class ExperimentTopicJmsPublisherApp implements ApplicationRunner
{
   @Autowired
   JMSTopicPublisher publisher;

   public static void main(String[] args)
   {
      SpringApplication.run(ExperimentTopicJmsPublisherApp.class, args);
   }

   @Override
   public void run(ApplicationArguments args) throws Exception
   {
      Exam ada = new Exam("Data Structures & Algorithms", 1);

      // send exam-1 details to topic.
      System.out.println("Sending exam-1 details.");
      publisher.send(ada);

      Exam automata = new Exam("Finite Automata", 2);

      // send exam-2 details to topic.
      System.out.println("Sending exam-2 details.");
      publisher.send(automata);
   }
}
