import java.io.*;
import java.util.Scanner;

/*
 * @author Sammantha Kelosi
 * */

public class EmployeeList{
    private static EmployeeNode head;

    public EmployeeList(){
        head=null;
    }

     /*
     *
     * */
    public void addEmployee(Employee employee){
        //create employee node to be added to list
        EmployeeNode new_employee = new EmployeeNode(employee);

        if(head==null){
            //if the list is empty
            new_employee.setNext(new_employee);
            new_employee.setPrev(new_employee);
            head = new_employee;
        }else{
            //if the list is not empty
            EmployeeNode tail = head.getPrev();
            new_employee.setNext(head);
            tail.setPrev(new_employee);
            new_employee.setPrev(tail);
            tail.setPrev(new_employee);
        }


    }


    /*
    * */
    public void removeEmployee(int id){
        if(head == null) {return;}

        EmployeeNode current = head;
        boolean found = false;

        do {
            if (current.getEmployee().getId() == id){
                found = true;
                break;
            }
            current = current.getNext();
        } while (current != head);

        if (found){
            EmployeeNode previousNode = current.getPrev();
            EmployeeNode nextNode = current.getNext();

            previousNode.setNext(nextNode);
            nextNode.setPrev(previousNode);

            if(current == head) {
                head = nextNode;
            }
        }
    }




    /**

     Removes the employee with the given ID from the linked list and updates the file "employees1.txt" with the remaining employees.

     @param id the ID of the employee to be removed

     @throws IOException if an I/O error occurs while writing to the file
     */
    public static void removeAndUpdateFile(int id) throws IOException {
        EmployeeNode current = head;
        boolean found = false;

        // Search for the employee with the given ID
        do {
            if (current.getEmployee().getId() == id) {
                found = true;
                break;
            }
            current = current.getNext();
        } while (current != head);

        if (found) {
            // Remove the employee from the linked list
            EmployeeNode previousNode = current.getPrev();
            EmployeeNode nextNode = current.getNext();

            previousNode.setNext(nextNode);
            nextNode.setPrev(previousNode);

            if (current == head) {
                head = nextNode;
            }

            // Write the remaining employees to the file
            FileWriter fileWriter = new FileWriter("employees1.txt", false);
            EmployeeNode node = head;
            do {
                fileWriter.write(node.getEmployee().toStringForFile() + "\n");
                node = node.getNext();
            } while (node != head);
            fileWriter.close();

            System.out.println("Employee with ID " + id + " has been removed from the list.");
            System.out.println("The updated list has been saved to the file employees.txt.");
        } else {
            System.out.println("Employee with ID " + id + " not found in the list.");
        }
    }






    /**

     Searches for the employee with the given telephone number and prints the employee's information if found.

     @param tel the telephone number to search for
     */
    public void searchByTelephone(String tel){

        if(head==null){
            System.out.println("List is empty");
            return;
        }

        EmployeeNode current = head;
        do{
            if(current.getEmployee().getTelephone_no().equals(tel)){
                System.out.println(current.getEmployee().toStringForFile());
                return;
            }
           current = current.getNext();
        }while (current != head);

    }



    /**

     Searches for employees with the given last name and prints their information.
     @param lname the last name to search for
     */
    public void searchBylName(String lname){
        if(head==null){
            System.out.println("No employees by that last name");
        }

        EmployeeNode current = head;
        do{
            Employee employee = (Employee) current.getEmployee();
            if(current.getEmployee().getLastName().equals(lname)){
                System.out.println(current.getEmployee().toStringForFile());
            }
            current = current.getNext();
        }while( current != head);

    }



    /**

     Searches for employees with the given highest qualification and returns a new EmployeeList containing these employees.

     @param lastName the highest qualification to search for

     @return a new EmployeeList containing employees with the given highest qualification
     */
    public EmployeeList searchQualification(String lastName){
        EmployeeList new_list = new EmployeeList();

        if(head==null){
            return null;
        }

        EmployeeNode current = head;
        do{
            if(current.getEmployee().getHighest_qualification().equals(lastName)){
                new_list.addEmployee(current.getEmployee());
            }
            current = current.getNext();
        }while (current != head);

        return new_list;

    }

    public void searchByQuali(String qualification){
        if(head==null){
            System.out.println("No with that qualification");
        }

        EmployeeNode current = head;
        do{
            Employee employee = (Employee) current.getEmployee();
            if(current.getEmployee().getHighest_qualification().equals(qualification)){
                System.out.println(current.getEmployee().toStringForFile());
            }
            current = current.getNext();
        }while( current != head);

    }

    /**/
    public  void display() throws IOException {
        if (head == null) {
            System.out.println("Employee list is empty!");
            return;
        }

        System.out.println("Employees in the list:");
        EmployeeNode current = head;
        do {
            System.out.println (current.getEmployee().toStringForFile());
            System.out.println("Here");
            current = current.getNext();
        } while (current != head);
    }


    public static void displays(EmployeeList emp) throws IOException {
        if (head == null) {
            System.out.println("Employee list is empty!");
            return;
        }

        EmployeeNode current = emp.getFirstNode();
        do {
            System.out.println (current.getEmployee().toStringForFile());
            current = current.getNext();
        } while (current != head);
    }



    public static void searchTel(String fileName,String tel) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] employeeData = line.split(",");
            int employeeId = Integer.parseInt(employeeData[0]);
            String firstName = employeeData[1];
            String lastName = employeeData[2];
            String address = employeeData[3];
            String telephoneNumber = employeeData[4];
            String email = employeeData[5];
            String dateJoined = employeeData[6];
            String highestQualification = employeeData[7];
            EmployeeList employeeList = new EmployeeList();
            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
            employeeList.addEmployee(employee);
            employeeList.searchByTelephone(tel);
        }

        scanner.close();

    }

    public static void searchLast(String fileName,String last) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] employeeData = line.split(",");
            int employeeId = Integer.parseInt(employeeData[0]);
            String firstName = employeeData[1];
            String lastName = employeeData[2];
            String address = employeeData[3];
            String telephoneNumber = employeeData[4];
            String email = employeeData[5];
            String dateJoined = employeeData[6];
            String highestQualification = employeeData[7];
            EmployeeList employeeList = new EmployeeList();
            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
            employeeList.addEmployee(employee);
            employeeList.searchBylName(last);
        }

        scanner.close();

    }

    public static void searchQualification(String fileName,String qualification) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] employeeData = line.split(",");
            int employeeId = Integer.parseInt(employeeData[0]);
            String firstName = employeeData[1];
            String lastName = employeeData[2];
            String address = employeeData[3];
            String telephoneNumber = employeeData[4];
            String email = employeeData[5];
            String dateJoined = employeeData[6];
            String highestQualification = employeeData[7];
            EmployeeList employeeList = new EmployeeList();
            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
            employeeList.addEmployee(employee);
            employeeList.searchByQuali(qualification);
        }

        scanner.close();

    }



    //Removing

    public static void removeId(String fileName,int id) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] employeeData = line.split(",");
            int employeeId = Integer.parseInt(employeeData[0]);
            String firstName = employeeData[1];
            String lastName = employeeData[2];
            String address = employeeData[3];
            String telephoneNumber = employeeData[4];
            String email = employeeData[5];
            String dateJoined = employeeData[6];
            String highestQualification = employeeData[7];
            EmployeeList employeeList = new EmployeeList();
            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
            employeeList.addEmployee(employee);
            removeAndUpdateFile(id);
        }

        scanner.close();

    }



    public static void loadFromFiles(String fileName) throws IOException {

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] employeeData = line.split(",");
            int employeeId = Integer.parseInt(employeeData[0]);
            String firstName = employeeData[1];
            String lastName = employeeData[2];
            String address = employeeData[3];
            String telephoneNumber = employeeData[4];
            String email = employeeData[5];
            String dateJoined = employeeData[6];
            String highestQualification = employeeData[7];
            EmployeeList employeeList = new EmployeeList();
            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
            employeeList.addEmployee(employee);

            displays(employeeList);


        }

        scanner.close();

    }


//    public static EmployeeList loadFromFiles1(String fileName) throws IOException {
//        File file = new File(fileName);
//        Scanner scanner = new Scanner(file);
//        EmployeeList employeeList = new EmployeeList();
//
//        do{
//            String line = scanner.nextLine();
//            String[] employeeData = line.split(",");
//            int employeeId = Integer.parseInt(employeeData[0]);
//            String firstName = employeeData[1];
//            String lastName = employeeData[2];
//            String address = employeeData[3];
//            String telephoneNumber = employeeData[4];
//            String email = employeeData[5];
//            String dateJoined = employeeData[6];
//            String highestQualification = employeeData[7];
//
//            Employee employee = new Employee(employeeId, firstName, lastName, address, telephoneNumber, email, dateJoined, highestQualification);
//            employeeList.addEmployee(employee);
//        }while(scanner.hasNextLine());
//
//        scanner.close();
//
//        return employeeList;
//    }



    //get Employee by Id
    public Employee searchById(int id) {
        if (head==null) {
            return null;
        } else {
            EmployeeNode current = head;
            do {
                if (current.getEmployee().getId() == id) {
                    return current.getEmployee();
                }
                current = current.getNext();
            } while (current != head);
            return null;
        }
    }



    public EmployeeNode getFirstNode() {
        return head;
    }







    public void traverseList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        EmployeeNode currentNode = head;
        do {
            System.out.println(currentNode.getEmployee().toString());
            System.out.println("Here");
            currentNode = currentNode.getNext();
        } while (currentNode != head);
    }




}


