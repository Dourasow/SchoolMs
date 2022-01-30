package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Course {
    
    private String courseID;
    private String courseName;
    private int credit;
    
    //Constructor
    public Course()
    {
        courseID = " ";
        courseName = " ";
        credit = 0;
    }
    
    //Polimorphism(Method Overloading)
    public Course(String courseID, String courseName, int credit)
    {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
    }
    
    //Accessors and Mutators(Getters and Setters)
    public String getCourseID()
    {
        return courseID;
    }
    public void setCourseID(String courseID)
    {
        this.courseID = courseID;
    }
    
    public String getCourseName()
    {
        return courseName;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    
    public int getCredit()
    {
        return credit;
    }
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    
        //Method to generate students marks
    public void generateDetails()
    {
      
       Connection con = null; //creating a connection
       
       try
       {
           System.out.println("---------------------------------------------------------STUDENTS MARKS REPORT-----------------------------------------------------------------------------------------------");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
          String query = "Select s.student_ID, s.first_Name, s.last_Name, s.department, s.level, c.course_Name, m.cat, m.exam"
                       + " from students s, courses c , mark m where s.student_ID = m.student_ID and c.course_ID = m.course_ID ";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(query);
          
          while(rs .next())
          {
              String student_ID = rs.getString("student_ID");
              String first_Name = rs.getString("first_Name");
              String last_Name = rs.getString("last_Name");
              String department = rs.getString("department");
              int level = rs.getInt("level");
              String course_Name = rs.getString("course_Name");
              float cat = rs.getFloat("cat");
              float exam = rs.getFloat("exam");
              
              float result = cat + exam;
           //   System.out.println(result);
              
              System.out.format("Student Id : %s , First Name : %s , Last Name : %s , Department : %s , Level : %s , Course name : %s , Cat : %s ,  Exam : %s , Total : %s \n" , student_ID, first_Name, last_Name, department, level, course_Name, cat, exam, result);
                      
          }
           st.close();
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
        
    }
}
