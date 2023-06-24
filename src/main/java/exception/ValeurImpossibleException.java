package exception;

/**
 * Implementation ValeurImpossibleException.
 */
public class ValeurImpossibleException extends Exception {

    /**
     * Met un message personnaliser à notre exception.
     *
     * @param message message à afficher
     */
    public ValeurImpossibleException(final String message) {
        super(message);
    }
}
