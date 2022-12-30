package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
       StudentDao stu = (StudentDao) context.getBean("studentDao");
       
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       
       Boolean go = true;
       while(go) {
       System.out.println();
       System.out.println("<**----------------**------Welcome To the Student Portal Please Choose the Below Options ------**-----------------**>");
       System.out.println();
       System.out.println("Press 1 for Add new Student ");
       System.out.println("Press 2 for Get All  Student ");
       System.out.println("Press 3 for Get Details for single Student ");
       System.out.println("Press 4 for Delete Single Student ");
       System.out.println("Press 5 for update  Student ");
       System.out.println("Press 6 for Exit ");
       System.out.println("<**----------------**--------------------------------------------------------------------------**-------------------**>");

       
       try {
		Integer choice = (Integer) Integer.parseInt(reader.readLine());
		switch (choice) {
		case 1:
			
			
			
			
			System.out.println("Enter Name of the Student");
			String name = reader.readLine();
			
			System.out.println("Enter Id of the student");
			Integer id = (Integer) Integer.parseInt(reader.readLine());

			System.out.println("Enter City of the student");
			String city = reader.readLine();

			Student student = new Student(name,id,city);
			int returnID = stu.insert(student);
			System.out.println("Student with ID : "+returnID +" Inserted Successfully ");
			break;
		case 2:
			//get all student
			List<Student> studentList = stu.getAllStudents();
			for(Student stu1 : studentList)
			{
				System.out.println("Name : " +stu1.getName() +" ID : "+stu1.getId()+ " City "+ stu1.getCity());
			}
			break;
		case 3:
		//  get sinlge studentk
			System.out.println("Enter Id of the student");
			Integer getStudentID = (Integer) Integer.parseInt(reader.readLine());
			Student getStudent  = stu.getStudent(getStudentID);
			if(getStudent.equals(null))
				 System.out.println("No student found for ID "+ getStudentID);
			System.out.println("Student Details : "+ getStudent);
			break;
			
		case 4:
			// delete student
			System.out.println("Enter Id of the student");
			Integer deleteId = (Integer) Integer.parseInt(reader.readLine());
		    stu.deleteStudent(deleteId);
		    System.out.println("Student with Id "+ deleteId + " deleted Succesffully" ); 
			break;
		
		case 5:
			System.out.println("Enter Id of the student for update ");
			Integer updateId= (Integer) Integer.parseInt(reader.readLine());
			
			System.out.println("Enter Name of the Student");
			String updateName = reader.readLine();
			

			System.out.println("Enter City of the student");
			String updateCity = reader.readLine();

			Student updateStudent = new Student(updateName,updateId,updateCity);
			
		    stu.updateStudent(updateStudent,updateId);		
		    System.out.println("Student with Id "+ updateId + " Updated Succesffully" ); 
			break;
		case 6:
			go=false;
			break;
		}
		
	  } catch (Exception e) {
	
	    System.out.print("Invalid input try with another :   ");
	    System.out.println(e.getMessage()); 
	  }
    }
      
     System.out.println("Thank you for using the application...!!");  
}
}
