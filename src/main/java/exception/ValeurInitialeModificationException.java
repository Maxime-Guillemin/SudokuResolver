package exception;

/**
 * Implementation ValeurInitialeModificationException.
 */
public class ValeurInitialeModificationException extends Exception {

    /**
     * Met un message personnaliser à notre exception.
     *
     * @param message message à afficher
     */
    public ValeurInitialeModificationException(final String message) {
        super(message);
    }
}
