/**

 A node class for a linked list of employees.
 @author Sammantha Kelosi
 */
public class EmployeeNode {
    private Employee employee; // the employee object stored in this node
    private EmployeeNode next; // reference to the next node in the list
    private EmployeeNode prev; // reference to the previous node in the list

    /**

     Constructor to create a new EmployeeNode with the given Employee object.
     @param employee the Employee object to store in the node
     */
    public EmployeeNode(Employee employee) {
        this.employee = employee;
        this.next = null;
        this.prev = null;
    }
    /**

     Getter method for the employee object stored in this node.
     @return the employee object stored in this node
     */
    public Employee getEmployee() {
        return employee;
    }
    /**

     Getter method for the next node in the list.
     @return the next node in the list
     */
    public EmployeeNode getNext() {
        return next;
    }
    /**

     Setter method for the next node in the list.
     @param next the next node to set
     */
    public void setNext(EmployeeNode next) {
        this.next = next;
    }
    /**

     Getter method for the previous node in the list.
     @return the previous node in the list
     */
    public EmployeeNode getPrev() {
        return prev;
    }
    /**

     Setter method for the previous node in the list.
     @param prev the previous node to set
     */
    public void setPrev(EmployeeNode prev) {
        this.prev = prev;
    }
}




