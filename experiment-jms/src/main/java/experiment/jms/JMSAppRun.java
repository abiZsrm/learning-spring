package experiment.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JMSAppRun
{
   public static void main(String[] args)
   {
      SpringApplication.run(JMSAppRun.class, args);
      
      System.out.println("Sending message.." );
      UserSender sender = new UserSender(); 
      
      String message = "Message sent - 1"; 
      sender.sendMessage(message);
      
   }
}
