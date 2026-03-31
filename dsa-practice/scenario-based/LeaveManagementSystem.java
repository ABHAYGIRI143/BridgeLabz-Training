
import java.util.*;

class LeaveManagement{

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee emp) {
        employeeMap.put(emp.getEmployeeId(), emp);
    }

    // Apply leave
    public void applyLeave(int employeeId, int days)
            throws InsufficientLeaveBalanceException {

        Employee emp = employeeMap.get(employeeId);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        if (emp.getLeaveBalance() < days) {
            throw new InsufficientLeaveBalanceException(
                    "Not enough leave balance!");
        }

        LeaveRequest request = new LeaveRequest(employeeId, days);
        leaveRequests.add(request);

        System.out.println("Leave request submitted: " + request);
    }

    // Approve leave
    public void approveLeave(int index) {
        LeaveRequest request = leaveRequests.get(index);
        Employee emp = employeeMap.get(request.getEmployeeId());

        emp.deductLeave(request.getDaysRequested());
        request.approve();

        System.out.println("Leave approved: " + request);
    }

    // Reject leave
    public void rejectLeave(int index) {
        LeaveRequest request = leaveRequests.get(index);
        request.reject();

        System.out.println("Leave rejected: " + request);
    }

    // Display all employees
    public void showEmployees() {
        employeeMap.values().forEach(System.out::println);
    }

    // Display leave requests
    public void showLeaveRequests() {
        for (int i = 0; i < leaveRequests.size(); i++) {
            System.out.println(i + ": " + leaveRequests.get(i));
        }
    }
}

public class LeaveManagementSystem  {
    public static void main(String[] args) {

        LeaveManagement system = new LeaveManagement();

        system.addEmployee(new Employee(1, "Abhay", 10));
        system.addEmployee(new Employee(2, "Rahul", 5));

        try {
            system.applyLeave(1, 3);
            system.applyLeave(2, 6); // Will throw exception
        } catch (InsufficientLeaveBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        system.showLeaveRequests();

        system.approveLeave(0);

        system.showEmployees();
    }
}
