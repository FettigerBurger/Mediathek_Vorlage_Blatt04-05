/**
 * Eine ProtokollierException signalisiert, dass das Protokollieren eines
 * Verleihvorgangs fehlgeschlagen ist.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class ProtokollierException extends Exception
{

    private static final long serialVersionUID = 1L;

    /**
     * Initilaisert eine neue Exception mit der übergebenen Fehlermeldung.
     * 
     * @param message Eine Fehlerbeschreibung.
     */
    public ProtokollierException(String message)
    {
        super(message);
    }
}
