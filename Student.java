package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student {
    
    private String studentID;
    private String firstName;
    private String lastName;
    private int level;
    private String department;
    private String phoneNumber;
    
    //Constructor
    public Student()
    {
        studentID = " ";
        firstName = " ";
        lastName = " ";
         level = 0;
        department = " ";
        phoneNumber = " ";
    }
    
    //polimorphism (Overloading Constructor)
    public Student(String studentID, String firstName, String lastName, int level, String department, String phoneNumber)
    {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }
    
    //Accessors and Mutators(Getters and Setters)
    public String getStudentID()
    {
        return studentID;
    }
    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public int getLevel()
    {
        return level;
    }
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    
     //Method to Search a student details using his id
    public void searchStudentDetails()
    {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); //Scanner 
        Connection con = null; // connection
        PreparedStatement insert; // statement that will allow me to create a query
            
        try
        {
            System.out.println("--------------------------------------------------------------------SEARCH STUDENT DETAILS-------------------------------------------------------------------------------------");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
           insert = con.prepareStatement("select * from students where student_ID = ? "); //creating query
           //Prompting the user to enter student Id he/she wants to find
             System.out.print("Enter student ID : "); 
             String student_ID = input.next();
             insert.setString(1, student_ID); //taking the id entered by user and set it to the student id column
           
            ResultSet rs = insert.executeQuery(); //creating a result set for the column in the database
          
            //checking if the Id entered by user exist in the database
            if(rs .next()==true)
                               {
                                   //creating variables that will hold each column from the database
                                   String first_Name = rs.getString("first_Name");
                                   String last_Name = rs.getString("last_Name");
                                   int level = rs.getInt("level");
                                   String department = rs.getString("department");
                                  String phone_Number = rs.getString("phone_Number");


                                   System.out.format("Student Id : %s , First Name : %s , Last Name : %s ,  Level : %d, Department : %s , Phone_Number : %s \n" , student_ID, first_Name, last_Name, level, department, phone_Number);

                               }
            else
            {
                System.out.println("Sorry Record Not Found!");
            }
   
        }catch(Exception e)
        {
            System.out.println("Invalid Query!");
        }
        
        
    }
}
