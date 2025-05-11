/**
 * PLZ ist eine Postleitzahl mit einer Länge von 5 Zeichen.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
final class PLZ
{
    // die Postleitzahl als Stringrepräsentation (z.B. 22761)
    private final String _plz;

    /**
     * Wählt eine PLZBlatt2 aus.
     * 
     * @param plz Die Postleitzahl als String.
     * 
     * @require istGueltig(plz)
     */
    public PLZ(String plz)
    {
        assert istGueltig(plz) : "Vorbedingung verletzt: istGueltig(plz) ";
        _plz = plz;
    }

    /**
     * Liefert true, wenn die Postleitzahl 5 Zeichen, andernfalls false.
     * 
     * @param plz Eine Postleitzahl zur Überprüfung
     * @return true, wenn die Postleitzahl 5 Zeichen hat, andernfalls false.
     */
    public static boolean istGueltig(String plz)
    {
        return plz.length() == 5;
    }

    /**
     * Zwei Postleitzahlen sind gleich wenn ihre Ziffernkombinationen gleich
     * sind. Ein eventuelles Prefix wird nicht überprüft.
     * 
     * @param obj Ein anderes Objekt.
     * @return true, wenn die die ziffernkombinationen gleich sind, ansonsten
     *         false.
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;
        if (obj instanceof PLZ)
        {
            PLZ vergleichsPLZ = (PLZ) obj;
            result = _plz.equals(vergleichsPLZ._plz);
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        return _plz.hashCode();
    }

    @Override
    public String toString()
    {
        return _plz;
    }
}
