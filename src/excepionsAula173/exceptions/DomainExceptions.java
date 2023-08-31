package excepionsAula173.exceptions;

public class DomainExceptions extends RuntimeException{
    private static final long serialVerionUID = 1L;

    public DomainExceptions(String message) {
        super(message);
    }
}
