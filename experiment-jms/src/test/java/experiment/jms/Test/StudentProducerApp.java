package experiment.jms.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import experiment.jms.StudentSender;
import experiment.jms.config.JMSConfig;
import experiment.jms.config.JMSProducerConfig;
import experiment.jms.dto.Student;

public class StudentProducerApp
{
   public static void main(String[] args)
      throws IOException
   {
      AbstractApplicationContext context = new AnnotationConfigApplicationContext( JMSConfig.class, JMSProducerConfig.class );
      
      // Retrieve the 'Student Sender' object. 
      StudentSender studentSender = context.getBean(StudentSender.class);
      
      // Collection of students. 
      List<Student> students = new ArrayList<Student>(); 
      Student student1 = new Student("Abhishek", "Madhusudhan", 30, "abizsrm@gmail.com"); 
      Student student2 = new Student("John", "Doe", 40, "johndoe@email.com"); 
      Student student3 = new Student("Alan", "Wake", 45, "alanwake@remedy.com"); 
      students.add(student1); 
      students.add(student2); 
      students.add(student3); 
      
      // Send the students. 
      students.forEach((Student student) -> studentSender.sendMessage(student)); 
      
      // Hold the thread. 
      System.in.read();
      
      // Close the context. 
      context.close();
   }
}
