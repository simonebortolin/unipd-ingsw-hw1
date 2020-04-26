public class ProgramException extends RuntimeException {
    public ProgramException() {
    }

    public ProgramException(String message) {
        super(message);
    }

    public ProgramException(Throwable cause) {
        super(cause);
    }

    public ProgramException(String message, Throwable cause) {
        super(message, cause);
    }
}
