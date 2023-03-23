import java.io.IOException;
import java.util.Scanner;

public class Display extends DisplayFunctions implements IEmpView  {

    public static void main(String[] args) throws IOException {
        System.out.println("EMPLOYEE LISTS");
        run();

    }


    public static void run() throws IOException {

        System.out.println("1.Display Employees");
        System.out.println("2.Add Employee");
        System.out.println("3.Remove Employee");
        System.out.println("4.Search Employeee By Telephone Number");
        System.out.println("5.Search Employee By Last Name");
        System.out.println("6.Display Employees By Qualifications");
        System.out.println("------------------------------------------------------------");
        System.out.println("Enter option below");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if(option==1){
            displayEmployees();
            run();

        }
        if(option==2){
            addEmployees();
            run();
        }
        if(option==3){
            removeEmployees();
            run();
        }
        if(option==4){
            searchTelephone();
            run();
        }
        if(option==5){
            searchLastName();
            run();
        }
        if(option==6){
            searchQualifications();
            run();
        }
        else {
            System.out.println("=======================================================================");
            run();
        }


    }

}
