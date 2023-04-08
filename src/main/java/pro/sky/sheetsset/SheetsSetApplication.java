package pro.sky.sheetsset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SheetsSetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SheetsSetApplication.class, args);

        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee("Петров", "Петр");
        employeeService.addEmployee("Сидоров", "Сидор");
        employeeService.addEmployee("Васильев", "Василий");
        employeeService.addEmployee("Соловьев", "Степан");
        employeeService.addEmployee("Степанов", "Григорий");

    }

}
