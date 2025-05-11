import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class VideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String SYSTEM = "System";
    private static final String FORMATIERTER_STRING = BEZEICHNUNG+":\n    Titel: "+TITEL+"\n    Kommentar: "+KOMMENTAR+"\n    System: "+SYSTEM+"\n";
    private Videospiel _videoSpiel;

    @Before
    public void setUp()
    {
        _videoSpiel = getMedium();
    }

    @Test
    public void testeKonstruktoren()
    {
        assertEquals(TITEL, _videoSpiel.getTitel());
        assertEquals(KOMMENTAR, _videoSpiel.getKommentar());
        assertEquals(SYSTEM, _videoSpiel.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String videospielBezeichnung = BEZEICHNUNG;
        assertEquals(videospielBezeichnung, _videoSpiel.getMedienBezeichnung());
    }

    protected Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
        Videospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals("Kommentar2", medium.getKommentar());
    }

    @Test
    public final void testSetTitel()
    {
        Videospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals("Titel2", medium.getTitel());
    }
    
    @Test
    public final void testGetFormatiertenString()
    {
        Medium medium = getMedium();
        assertNotNull(medium.getFormatiertenString());
        assertEquals(FORMATIERTER_STRING, medium.getFormatiertenString());
    }
}
