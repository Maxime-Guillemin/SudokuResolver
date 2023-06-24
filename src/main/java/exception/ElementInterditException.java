package exception;

/**
 * Implementation ElementInterditException.
 */
public class ElementInterditException extends Exception {

    /**
     * Met un message personnaliser à notre exception.
     *
     * @param message message à afficher
     */
    public ElementInterditException(final String message) {
        super(message);
    }
}
