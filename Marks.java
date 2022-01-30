package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author ues
 */
public class Marks {
    
    private String studentID;
    private String courseID;
    private double cat;
    private double exam;
    
    //Constructor
    public Marks()
    {
        studentID = " ";
        courseID = " ";
        cat = 0.0;
        exam = 0.0;
    }
    
    //Polimorphism(Overloaded Constructor)
    public Marks(double cat, double exam)
    {
        this.cat = cat;
        this.exam = exam;
    }
    
    //Accessors and Mutators(Getters and Setters)

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }   
    
    public double getCat()
    {
        return cat;
    }
    public void setCat(double cat)
    {
        this.cat = cat;
    }
    
    public double getExam()
    {
        return exam;
    }
    public void setExam(double exam)
    {
           this.exam = exam;
    }

      
          //Methods to Update Marks by his student Id and course_ID
    public  void updateMarks()
    {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
         Connection con = null;
        
        try
        {
             System.out.println("--------------------------------------------------------------------UPDATE STUDENT MARKS-------------------------------------------------------------------------------------");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
         
                               System.out.print("Enter Student_ID :  ");
                              String student_ID = input.next();
                          
                                System.out.print("Enter Course ID : ");
                                String course_ID = input.next();
                              
                                System.out.print("Enter New Cat Mark :");
                                double cats = input.nextDouble();
                             
                                System.out.print("Enter New Exam Mark : ");
                                double exams = input.nextDouble();
                                
                           
                                 
                                 PreparedStatement insert = con.prepareStatement("update mark set cat = ?, exam = ? where student_ID = ? and course_ID = ?");
                                 insert.setDouble(1, cats);
                                 insert.setDouble(2, exams);
                                 insert.setString(3, student_ID);
                                 insert.setString(4, course_ID);
                                 
                                 int i = insert.executeUpdate();
                                 
                                 if (i >0)
                                 {
                                     System.out.println("Record Updated Succesfully");
                                 }
                                 else
                                 {
                                     System.out.println("Sorry!, Record not found!");
                                 }
                     
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    }

