package exception;

/**
 * Implementation HorsBornesException.
 */
public class HorsBornesException extends Exception {

    /**
     * Met un message personnaliser à notre exception.
     *
     * @param message message à afficher
     */
    public HorsBornesException(final String message) {
        super(message);
    }
}
