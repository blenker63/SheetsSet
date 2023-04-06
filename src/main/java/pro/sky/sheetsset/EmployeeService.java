package pro.sky.sheetsset;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private Employee[] employees;
    private static int counter = 0;
    public EmployeeService() {
        this.employees = new Employee[10]; // объявление длины массива
    }

    public void addEmployee(String firstName, String lastName) {
        if (counter >= employees.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        }
        Employee newEmployee = new Employee();
        employees[counter++] = newEmployee;
    }

    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getLastName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, counter - i - 1);
                counter-;
                return;
            }
        }
    }


}
