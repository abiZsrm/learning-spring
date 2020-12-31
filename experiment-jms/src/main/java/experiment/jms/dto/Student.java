package experiment.jms.dto;

import java.io.Serializable;

public class Student implements Serializable
{
   private String m_firstName; 
   private String m_lastName; 
   private int m_age; 
   private String m_email; 
   
   public Student( String firstName, String lastName,
                   int age, String email )
   {
      this.m_firstName = firstName; 
      this.m_lastName = lastName; 
      this.m_age = age; 
      this.m_email = email; 
   }
   
   public String getFirstName()
   {
      return this.m_firstName; 
   }
   
   public String getLastName()
   {
      return this.m_lastName; 
   }
   
   public int getAge()
   {
      return this.m_age;
   }
   
   public String getEmail()
   {
      return this.m_email; 
   }
   
   public String toString()
   {
      return "(Student Name: " + this.m_firstName + ":" + this.m_lastName + ", "
            + "Age: " + Integer.toString(this.m_age) + ", "
            + "Email: " + this.m_email + ")"; 
   }
}
