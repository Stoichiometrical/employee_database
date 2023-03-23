import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DisplayFunctions extends EmployeeList {

    /**

     This method displays all employees in the employee database by calling the loadFromFiles method.
     @throws IOException if there's an error loading the employee database from file.
     */
    public static  void displayEmployees() throws IOException {
     loadFromFiles("employees.txt");
    }

    /**

     This method prompts the user to enter the details of a new employee and adds them to the employee database file.

     If the employee database file does not exist, it will be created.
     */
    public static void addEmployees(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id :  ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter first name : ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name : ");
        String lastName = scanner.nextLine();

        System.out.println("Enter phone number : ");
        String tel_no = scanner.nextLine();

        System.out.println("Enter address :  ");
        String address = scanner.nextLine();

        System.out.println("Enter email :  ");
        String email = scanner.nextLine();

        System.out.println("Enter date joined :  ");
        String dateJoined = scanner.nextLine();

        System.out.println("Enter highest qualification :  ");
        String highestQualification = scanner.nextLine();

        Employee newEmployee = new Employee(id,firstName,lastName,address,tel_no,email,dateJoined,highestQualification);



        try{
            FileWriter fileWriter = new FileWriter("employees.txt",true);
            fileWriter.write(newEmployee.toStringForFile() + "\n");
            fileWriter.close();
            System.out.println("Employee Successfully added to database");
            System.out.println("--------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static  void removeEmployees() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the employee you want to remove");
        int id = scanner.nextInt();
//        scanner.nextLine();
        removeId("employees1.txt",id);
        System.out.println("\n");
//        removeEmps(id);
    }


    /**
     * Allows a user to search for an employee in the database by their telephone number.
     * Prompts the user to enter the telephone number of the employee they are looking for and
     * displays the information of the employee(s) with the matching telephone number in the console.
     *
     * @throws IOException if there is an error accessing the database file.
     */
    public static void searchTelephone() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phone number of the employee you are looking for :  ");
        String tel = scanner.nextLine();
        searchTel("employees.txt",tel);
        System.out.println("\n");
        System.out.println("---------------------------------------------");

    }

    /**
     * Allows a user to search for an employee in the database by their last name.
     * Prompts the user to enter the last name of the employee they are looking for and
     * displays the information of the employee(s) with the matching last name in the console.
     *
     * @throws IOException if there is an error accessing the database file.
     */
    public static void searchLastName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the last name of the employee you are looking for :  ");
        String lastname = scanner.nextLine();
        searchLast("employees.txt",lastname);
        System.out.println("\n");
        System.out.println("---------------------------------------------");

    }

    /**
     * Allows a user to search for employees in the database by their highest qualification.
     * Prompts the user to enter the highest qualification of the employees they are looking for and
     * displays the information of the employee(s) with the matching qualification in the console.
     *
     * @throws IOException if there is an error accessing the database file.
     */
    public static void searchQualifications() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  highest qualification of the employees you are looking for :  ");
        String qualification = scanner.nextLine();
        searchQualification("employees.txt",qualification);
        System.out.println("\n");
        System.out.println("---------------------------------------------");

    }



}
