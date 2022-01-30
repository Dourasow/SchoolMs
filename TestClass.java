
package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TestClass {
	
	public void startMenu()
	{
		
			Connection con =null; //Creating a connection

        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        
        Student stud = new Student(); // Creating Object of the Student class
        Course cou = new Course(); //Creating Object of the Course class
        Marks mar = new Marks(); //Creating Object of the Marks class
        
        System.out.println("---------------------------------------------------------------------------------WELCOME TO SOW's SCHOOL-----------------------------------------------------------------------------");

        System.out.println(" 1. Add Student \n" +
                           " 2. Add Course \n" +
                           " 3. Add Marks \n" +
                           " 4. Generate Student's Report \n" +
                           " 5. Search Student Details \n" +
                           " 6. Update Marks \n " +
        				   "7. Exit");
  
        System.out.print("Choose an Option : ");
        int opt = input.nextInt();
        
        do {
        	switch(opt)
        		{
                    case 1:
                        System.out.print("Enter Student ID : ");
                                   stud.setStudentID(input.next());
                        System.out.print("Enter Student's First Name : ");
                                   stud.setFirstName(input.next());
                        System.out.print("Enter Student's Last Name : ");
                                  stud.setLastName(input.next());
                        System.out.print("Enter Student Level : ");
                                  stud.setLevel(input.nextInt());
                        System.out.print("Enter Student's Department : ");
                                   stud.setDepartment(input.next());
                        System.out.print("Enter Student Phone Number : ");
                                    stud.setPhoneNumber(input.next());
                        try
                        {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
                            Statement stmt = con.createStatement();
                            if(!con.isClosed())
                            {

                              stmt.execute("insert into students values('" + stud.getStudentID()+"', '" + stud.getFirstName() + "' , '" + stud.getLastName() + "', " + stud.getLevel() + ", ' " + stud.getDepartment() + "', '" + stud.getPhoneNumber()+"')");
                                    System.out.println("Record Added Successfully");
                            }
                            else
                            {
                                System.out.println("Connection Failed!");
                            }
                        }catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                                        
			                             System.out.print("Do you want to Continue? : ");
			                             String y = input.next();
			                             
			                             switch (y)
			                             {
			                             case "Y":
			                            	 startMenu();
			                            	 break;
			                             case "N":
			                            	 System.out.println("Thanks for using our services");
			                            	 System.exit(0);
			                            	 break;
			                             default:
						                	  System.out.println("Invalid Option!");
						                	  break;
			                             }
                         break;
                    case 2:
                        System.out.print("Enter Course ID : ");
                                 cou.setCourseID(input.next());
                        System.out.println("Enter Course Name : ");
                                cou.setCourseName(input.next());
                        System.out.print("Enter Course Credit : ");
                                cou.setCredit(input.nextInt());

                        try
                        {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
                            Statement stmt = con.createStatement();
                            if(!con.isClosed())
                            {
                                stmt.execute("insert into courses values('"+cou.getCourseID()+"', '"+cou.getCourseName()+"', "+cou.getCredit()+")");
                                System.out.println("Record Added Succesfully");
                            }
                            else
                            {
                                System.out.println("Connection failed!");
                             }
                        }catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                                    
			                   System.out.print("Do you want to Continue? : ");
			                   String b = input.next();
			                   
			                   switch (b)
			                   {
			                   case "Y":
			                  	 startMenu();
			                  	 break;
			                   case "N":
			                  	 System.out.println("Thanks for using our services");
			                  	System.exit(0);
			                  	 break;
			                   default:
				                	  System.out.println("Invalid Option!");
				                	  break;
			                   }
			         break;
                    case 3:
                        System.out.print("Enter Student's ID : ");
                                mar.setStudentID(input.next());
                        System.out.print("Enter Course's ID : ");
                                mar.setCourseID(input.next());
                        System.out.print("Enter Cat's Grade : ");
                                mar.setCat(input.nextDouble());
                         System.out.print("Enter Exam's Grade : ");
                                mar.setExam(input.nextDouble());

                         try
                         {
                             con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school", "root", "");
                             Statement stmt = con.createStatement();
                             if(!con.isClosed())
                             {
                                 stmt.execute("insert into mark values('"+mar.getStudentID()+"','"+mar.getCourseID()+"', " + mar.getCat()+", "+mar.getExam()+")");
                                 System.out.println("Record Added Succesfully");
                             }
                         }catch(Exception e)
                         {
                             System.out.println(e.getMessage());
                         }
				                         
                         				System.out.print("Do you want to Continue? : ");
						                   String c = input.next();
						                   
						                   switch (c)
						                   {
						                   case "Y":
						                  	 startMenu();
						                  	 break;
						                   case "N":
						                  	 System.out.println("Thanks for using our services");
						                  	System.exit(0);
						                  	 break;
						                  	 
						                   default:
							                	  System.out.println("Invalid Option!");
							                	  break;
						                   }
                         
                       break;
                    case 4:
                         cou.generateDetails();
                         
				                         System.out.print("Do you want to Continue? : ");
						                   String d = input.next();
						                   
						                   switch (d)
						                   {
						                   case "Y":
						                  	 startMenu();
						                  	 break;
						                   case "N":
						                  	 System.out.println("Thanks for using our services");
						                  	 	System.exit(0);
						                  	 break;
						                  default:
						                	  System.out.println("Invalid Option!");						           
						                	  break;
						                   }
                        break;
                    case 5:
                        stud.searchStudentDetails();
                        
				                        System.out.print("Do you want to Continue? : ");
						                   String e = input.next();
						                   
						                   switch (e)
						                   {
						                   case "Y":
						                  	 startMenu();
						                  	 break;
						                   case "N":
						                  	 System.out.println("Thanks for using our services");
						                  	 System.exit(0);
						                  	 break;
						                   default:
							                	  System.out.println("Invalid Option!");
							                	  break;
						                   }
                        break;
                    case 6:
                        mar.updateMarks();
                        
				                        System.out.print("Do you want to Continue? : ");
						                   String f = input.next();
						                   
						                   switch (f)
						                   {
						                   case "Y":
						                  	 startMenu();
						                  	 break;
						                   case "N":
						                  	 System.out.println("Thanks for using our services");
						                  	 System.exit(0);
						                  	 break;
						                   default:
							                	  System.out.println("Invalid Option!");
							                	  break;
						                   }
                       break;
                       
                    case 7:
                        System.out.println("Thanks for using our services");
                        break;
                    default:
                                            System.out.println("Invalid Option!");
                                            break;
                }     
        
        } while(opt!=7);
        		
	}
  
    public static void main(String[] args)
    {
    	TestClass test = new TestClass();
    	
    	test.startMenu();
        
    }
    
}
