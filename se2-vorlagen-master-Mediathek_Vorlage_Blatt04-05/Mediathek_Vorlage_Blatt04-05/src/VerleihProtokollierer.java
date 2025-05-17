import java.io.FileWriter;
import java.io.IOException;

/**
 * VerleihProtokollierer ist eine Klasse zur protokollierung der Ausleihen und Rückgaben der Mediathek.
 */
public class VerleihProtokollierer
{
    public static final String AUSLEIHE = "Ausleihe";
    public static final String RUECKGABE = "Rückgabe";

    /** 
     * @throws ProtokollierException
     * @param ereignis
     * @param verleihkarte
     * 
     * @require ereignis != null
     * @require ereignis.equals(RUECKGABE) || ereignis.equals(AUSLEIHE)
     */
    public static void protokolliere(String ereignis, Verleihkarte verleihkarte)
            throws ProtokollierException
    {
        assert ereignis.equals(AUSLEIHE) || ereignis.equals(
                RUECKGABE) : "Vorbedingung verletzt: ereignis.equals(AUSLEIHE) || ereignis.equals(RUECKGABE)";

        try (FileWriter writer = new FileWriter("./protokoll.txt", true))
        {

            writer.write(ereignis + " von "
                    + verleihkarte.getFormatiertenString() + "\n");
        }
        catch (IOException e)
        {
            throw new ProtokollierException(e.getMessage());
        }
        finally
        {
            System.out.print("Protokolliervorgang beendet.");
        }

        //        System.out
        //            .println(ereignis + " von " + verleihkarte.getFormatiertenString());
    }
}
