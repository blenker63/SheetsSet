package pro.sky.sheetsset;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
}
