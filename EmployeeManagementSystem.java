import java.util.*;

public class EmployeeManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Multiple Employees");
            System.out.println("3. Display Employees");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    system.addSingleEmployee(scanner);
                    break;
                case 2:
                    system.addMultipleEmployees(scanner);
                    break;
                case 3:
                    system.displayEmployees();
                    break;
                case 4:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    system.searchEmployee(searchId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    // Method to add a single employee
    public void addSingleEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        addEmployee(name, id, department);
    }

    // Method to add multiple employees
    public void addMultipleEmployees(Scanner scanner) {
        System.out.print("Enter the number of employees to add: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            addSingleEmployee(scanner);
        }
    }

    // Method to add an employee to the list
    public void addEmployee(String name, int id, String department) {
        if (isValidName(name) && isValidId(id) && isValidDepartment(department)) {
            Employee employee = new Employee(name, id, department);
            employees.add(employee);
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Invalid input. Employee not added.");
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= 50;
    }

    private boolean isValidId(int id) {
        return id >= 1 && id <= 9999;
    }

    private boolean isValidDepartment(String department) {
        return !department.isEmpty();
    }

    // Method to display all employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees added yet.");
            return;
        }
        System.out.println("List of employees:");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId() + ", Department: " + employee.getDepartment());
        }
    }

    // Method to search for an employee by ID
    public void searchEmployee(int id) {
        if (isValidId(id)) {
            boolean found = false;
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    System.out.println("Employee found:");
                    System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId() + ", Department: " + employee.getDepartment());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee with ID " + id + " not found.");
            }
        } else {
            System.out.println("Invalid ID. Please provide a valid employee ID.");
        }
    }

}

// Employee class with basic properties
class Employee {
    private String name;
    private int id;
    private String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
}
