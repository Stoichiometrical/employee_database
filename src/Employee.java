import java.util.Date;
import java.util.StringJoiner;

public class Employee  implements IEmpView{
    /**
     * This class contains is used to create employee objects with all thier details
     * @param id the id of employee
     * @param first_name the first name of the employee
     * @param last_name the last name of the employee
     *
     */

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone_no;
    private String email;
    private String date_joined;
    private String highest_qualification;

    public Employee(int id, String firstName, String lastName, String address, String telephone_no, String email, String date_joined, String highest_qualification) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone_no = telephone_no;
        this.email = email;
        this.date_joined = date_joined;
        this.highest_qualification = highest_qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone_no() {
        return telephone_no;
    }

    public void setTelephone_no(String telephone_no) {
        this.telephone_no = telephone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public String getHighest_qualification() {
        return highest_qualification;
    }

    public void setHighest_qualification(String highest_qualification) {
        this.highest_qualification = highest_qualification;
    }


    public String toStringForFile() {
        return id + "," + firstName + "," + lastName + "," + address + "," + telephone_no + "," + email + "," + date_joined + "," + highest_qualification ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", telephone_no='" + telephone_no + '\'' +
                ", email='" + email + '\'' +
                ", date_joined='" + date_joined + '\'' +
                ", highest_qualification='" + highest_qualification + '\'' +
                '}';
    }

    @Override
    public void display() {
        System.out.println("Employee Details : ");
        System.out.println("ID :" + this.id + "First Name : " + this.firstName +
                "Last Name : " + this.lastName +  " Address:  " + this.address +
                " Telephone Number : " + this.telephone_no +  " Email : "
                + this.email + "Date Joined : " + this.date_joined + "Highest Qualification : " + this.highest_qualification);
    }


    public static class EmployeeTest{
        public void main(String[] args) {
            //create employee object
            Employee new_employee = new Employee(1,"Peter","James","ALC Campus","1625252662","pjames@gmail.com","22-03-2018","HSC");
            //test to see if the display method is working  correctly
            new_employee.display();
        }
    }
}
