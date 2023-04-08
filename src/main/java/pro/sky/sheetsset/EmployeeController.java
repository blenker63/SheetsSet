package pro.sky.sheetsset;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName) {

        return "firstName: " + firstName + " , " + "lastName: " + lastName;
    }
    @GetMapping(path = "/employee/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {

        return "firstName: " + firstName + " , " + "lastName: " + lastName;
    }
    @GetMapping(path = "/employee/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {

        return "firstName: " + firstName + " , " + "lastName: " + lastName;
    }


}
