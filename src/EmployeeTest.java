/**

 The EmployeeTest class is used to test the Employee class by creating an Employee object,

 setting its properties using the setters and retrieving the properties using the getters.
 */
public class EmployeeTest {

    /**

     The main method creates an Employee object, sets its properties using the setters and retrieves

     the properties using the getters. It then prints out the employee details and changes some of the

     properties using the setters again, and prints out the updated employee details.

     @param args the command line arguments
     */
    public static void main(String[] args) {
// create a new employee object
        Employee new_employee = new Employee(1,"Peter","James","ALC Campus","1625252662","pjames@gmail.com","22-03-2018","HSC");

// test the getters by printing out the employee details
        System.out.println("Employee Details : " + new_employee.getId());
        System.out.println("First Name : " + new_employee.getFirstName());
        System.out.println("Last Name : " + new_employee.getLastName());
        System.out.println("Address " + new_employee.getAddress());
        System.out.println("Telephone Number : " + new_employee.getTelephone_no());
        System.out.println("Email Address : " + new_employee.getEmail());
        System.out.println("Date Joined : " + new_employee.getDate_joined());
        System.out.println("Highest Qualification : " + new_employee.getHighest_qualification());

// set some properties using the setters
        new_employee.setId(1);
        new_employee.setFirstName("Rudo");
        new_employee.setLastName("Tanaka");
        new_employee.setAddress("Chegutu");
        new_employee.setTelephone_no("242424242573");
        new_employee.setEmail("rtanaka@gmail.com");
        new_employee.setDate_joined("20-08-18");
        new_employee.setHighest_qualification("BSC");

// see if the properties have changed by printing out the updated employee details
        String employee_details = new_employee.toString();
        System.out.println(employee_details);
    }

}





