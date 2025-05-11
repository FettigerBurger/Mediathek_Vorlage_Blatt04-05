import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testklasse für den MedienComparator
 * 
 * @author SE2-Team
 * 
 */
public class MedienComparatorTest
{

    private CD _cd1;
    private CD _cd2;
    private CD _cd3;
    private DVD _dvd;
    private Videospiel _videospiel;
    private MedienComparator _medienComparator;

    @Before
    public void setUp() throws Exception
    {

        _cd1 = new CD("Titel a", "Kommentar", "Interpret", 100);
        _cd2 = new CD("Titel b", "Kommentar", "Interpret", 100);
        _cd3 = new CD("Titel b", "Kommentar", "Interpret", 100);

        _dvd = new DVD("Titel a", "Kommentar", "Regisseur", 100);
        _videospiel = new Videospiel("Titel a", "Kommentar", "Wii");

        _medienComparator = new MedienComparator();
    }

    @Test
    public void testCompareEinMedium()
    {
        assertTrue(_medienComparator.compare(_cd3, _cd1) > 0);
        assertTrue(_medienComparator.compare(_cd1, _cd2) < 0);
        assertEquals(0, _medienComparator.compare(_cd3, _cd2));
    }

    @Test
    public void testCompareVerschiedeneMedien()
    {
        assertTrue(_medienComparator.compare(_cd2, _dvd) < 0);
        assertTrue(_medienComparator.compare(_dvd, _videospiel) < 0);
    }
}
