import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//Die in den Testfällen verwendeten assert-Anweisungen werden über
//einen sogenannten statischen Import bereitgestellt, zum Beispiel:
//import static org.junit.Assert.assertEquals;
//
//Um die Annotationen @Test und @Before verwenden zu können, müssen diese
//importiert werden, zum Beispiel:
//import org.junit.Test;

public class CDTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "CD";
    private static final String INTERPRET = "CD Interpret";
    private static final int LAENGE = 100;
    private CD _cd1;
    private CD _cd2;

    @Before
    // Die setUp()-Methode wird nicht mehr anhand ihres Namens erkannt, sondern
    // anhand der Annotation @Before.
    public void setUp()
    {
        _cd1 = getMedium();
        _cd2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        assertEquals(BEZEICHNUNG, _cd1.getMedienBezeichnung());
    }

    @Test
    // Alle Testmethoden erhalten die Annotation @Test. Dafür müssen diese nicht
    // mehr mit test im Namen beginnen. Dies wird jedoch aus Gewohnheit
    // oft weiter verwendet.
    public void testKonstruktor()
    {
        assertEquals(TITEL, _cd1.getTitel());
        assertEquals(KOMMENTAR, _cd1.getKommentar());
        assertEquals(LAENGE, _cd1.getSpiellaenge());
        assertEquals(INTERPRET, _cd1.getInterpret());
    }

    @Test
    public final void testSetter()
    {
        _cd1.setTitel("Titel2");
        assertEquals("Titel2", _cd1.getTitel());
        _cd1.setKommentar("Kommentar2");
        assertEquals("Kommentar2", _cd1.getKommentar());
        _cd1.setInterpret("Interpret2");
        assertEquals("Interpret2", _cd1.getInterpret());
        _cd1.setSpiellaenge(99);
        assertEquals(99, _cd1.getSpiellaenge());
    }

    @Test
    /*
     * Von ein und der selben CD kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertNotEquals(
                "Mehrere Exemplare der gleichen CD sollten ungleich sein", _cd1,
                _cd2);
        assertEquals("Dasselbe Exemplare der gleichen CD sollte gleich sein",
                _cd1, _cd1);
    }

    @Test
    public final void testGetFormatiertenString()
    {
        Medium medium = getMedium();
        assertNotNull(medium.getFormatiertenString());
        String[] containArray = {BEZEICHNUNG, TITEL, KOMMENTAR, INTERPRET,
                String.valueOf(LAENGE)};
        for (String testString : containArray)
        {
            assertTrue(medium.getFormatiertenString()
                .contains(testString));
        }
    }

    @Test
    public void berechneMietgebuehr()
    {
        Medium medium = getMedium();
        assertTrue(medium.berechneMietgebuehr(1) != null);
        assertEquals(new Geldbetrag(300), medium.berechneMietgebuehr(1));
        assertEquals(new Geldbetrag(3000), medium.berechneMietgebuehr(10));
    }

    private CD getMedium()
    {
        return new CD(TITEL, KOMMENTAR, INTERPRET, LAENGE);
    }

}
