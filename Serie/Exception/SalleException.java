public class SalleException extends Exception {
    // Constructeur par défaut
    public SalleException() {
        super();
    }

    // Constructeur avec un message personnalisé
    public SalleException(String message) {
        super(message);
    }

    // Constructeur avec un message et une cause
    public SalleException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructeur avec une cause
    public SalleException(Throwable cause) {
        super(cause);
    }
}
