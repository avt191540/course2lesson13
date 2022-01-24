package pro.sky.course2lesson13.service;

import org.springframework.stereotype.Service;
import pro.sky.course2lesson13.Employee;
import pro.sky.course2lesson13.EmployeeBook;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeBook employeeBook;

    @Override
    public String addEmployeeToBook(String firstName, String lastName, int department, double salary) {
//        firstName = checkingInputTextData(firstName);
//        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
//        employeeBook.addEmployee(employee);
//        if (employee.contains(employee1)) {
//            throw new DataMatchException();
//        }
//        employee.add(employee1);
        return (employeeBook.addEmployee(employee).toString());
    }
    @Override
    public int sizeEmployeeBook() {
//        int numberEmployees = employee.size();
        return employeeBook.sizeEmployees();
    }
    @Override
    public List getEmployeeBook() {
        return employeeBook.getEmployees();
    }
    @Override
    public String removeEmployeeFromBook(String firstName, String lastName, int department, double salary) {
//        firstName = checkingInputTextData(firstName);
//        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
//        if (employee.contains(employee1)) {
//            employee.remove(employee1);
            return (employeeBook.removeEmployee(employee).toString());
//        } else
//            throw new NotFoundException();
    }
    @Override
    public Employee findEmployeeInBook(String firstName, String lastName, int department, double salary) {
//        firstName = checkingInputTextData(firstName);
//        lastName = checkingInputTextData(lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
//        if (employee.contains(employee1)) {
            return employeeBook.findEmployee(employee);
//        }
//        throw new NotFoundException();
    }
    @Override
    public Employee searchEmployeeDepartmentMaxSalary(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    @Override
    public Employee searchEmployeeDepartmentMinSalary(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    @Override
    public List getAllEmployeesOfDepartment(int department) {
        return employeeBook.getEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public Map getEmployeesByDepartments() {
        Map<Integer, List<Employee>> map = employeeBook.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return map;
    }
}
