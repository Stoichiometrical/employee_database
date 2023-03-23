import java.io.IOException;

/*
 * @author Sammantha Kelosi
 * */

public class EmployeeListTest {

    public static void main(String[] args) throws IOException {

        //create  an employee list
        EmployeeList employee_list = new EmployeeList();

        //create employees to be added to the list
        Employee employee1 = new Employee(1,"Peter","Maths","ALC Campus","2423242424","pmaths@gmail.com","20-12-2020","BSC");
        Employee employee2 = new Employee(2,"Mary","Baoo","ALC Campus","892756446","mbaoo@gmail.com","20-12-2020","MSC");
        Employee employee3 = new Employee(3,"Purity","Mop","ALC Campus","67788924","pmop@gmail.com","21-12-2020","BSC");
        Employee employee4 = new Employee(4,"Jonas","Mopongo","Middle Valley","6727272822","jmopongo@gmail.com","25-12-2010","MSC");

        //add the employees to the list
        employee_list.addEmployee(employee1);
        employee_list.addEmployee(employee2);
        employee_list.addEmployee(employee3);
        employee_list.addEmployee(employee4);

        //display list
        employee_list.display();

       //remove employee
        System.out.println("Remove Peter");
        employee_list.removeEmployee(1);
        employee_list.display();





        //Search by qualifications
        System.out.println("Employees With Qualifications : James");
        EmployeeList qualifications = employee_list.searchQualification("BSC");
        if(qualifications !=null){
            System.out.println(qualifications.toString());
        }
        else {
            System.out.println("No Employees With Qualifications : James");
        }



    }
}
