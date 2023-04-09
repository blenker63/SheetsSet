package pro.sky.sheetsset;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
