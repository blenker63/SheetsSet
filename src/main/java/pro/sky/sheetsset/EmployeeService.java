package pro.sky.sheetsset;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(100);

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() > 100) {
            throw new EmployeeStoragelsFullException("Список переполнен");
        }
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            }
        }
        var e = new Employee(firstName, lastName);
        employees.add(e);
        return e;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee getEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Collection<Employee> getEmployees() {

        return Collections.unmodifiableList(employees);
    }
}

