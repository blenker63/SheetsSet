package pro.sky.sheetsset;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private Employee[] employees;
    private static int counter = 0;

    public EmployeeService() {
        this.employees = new Employee[10]; // объявление длины массива
    }

    public void addEmployee(String firstName, String lastName) throws EmployeeStoragelsFullException,
            EmployeeAlreadyAddedException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
            } else if (counter >= employees.length) {
                throw new EmployeeStoragelsFullException("Нельзя добавить сотрудника, закончилось место");
            }
            Employee newEmployee = new Employee();
            employees[counter++] = newEmployee;
        }
    }

    public void removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.length; i++) {
            if (!employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            } else {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getLastName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, counter - i - 1);
                employees[counter - 1] = null;

            }
        }
    }

    public void findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < counter; i++) {
            Employee employee = employees[i];
            if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getLastName() + " найден");
                return;
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
    }
}


