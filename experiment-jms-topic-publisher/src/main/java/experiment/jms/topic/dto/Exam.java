package experiment.jms.topic.dto;

import java.io.Serializable;

public class Exam implements Serializable
{
   // The instance variable names must follow a uniform naming convention for jackson deserialization. 
   private String examName; 
   private int examYear; 

   // Default constructor required for jackson deserialization process. 
   public Exam()
   {
      
   }
   
   public Exam( String examName, int examYear )
   {
      this.examName = examName; 
      this.examYear = examYear;  
   }
   
   public String getExamName()
   {
      return this.examName; 
   }
   
   public int getExamYear()
   {
      return this.examYear;
   }
   
   public String toString()
   {
      return "(Exam Name: " + this.examName + ", "
            + "Exam Year: " + Integer.toString(this.examYear) + ")"; 
   }
}
