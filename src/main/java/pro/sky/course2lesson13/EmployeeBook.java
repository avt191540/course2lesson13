package pro.sky.course2lesson13;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {

    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeExistException();
        }
        employees.add(employee);
        return (employee);
    }
}

