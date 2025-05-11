import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MedienverwaltungMedienTableModelTest
{

    private Medium _cd1;
    private Medium _cd2;
    private Medium _cd3;
    private MedienverwaltungMedienTableModel _model;

    @Before
    public void setUp()
    {
        _cd1 = new CD("CD1-Titel", "CD1-Kommentar", "CD1-Interpret", 42);
        _cd2 = new CD("CD2-Titel", "CD2-Kommentar", "CD2-Regisseur", 120);
        _cd3 = new CD("CD1-Titel", "CD1-Kommentar", "CD1-Interpret", 42);
        List<Medium> medien = new ArrayList<Medium>();
        medien.add(_cd1);
        medien.add(_cd2);
        medien.add(_cd3);
        _model = new MedienverwaltungMedienTableModel();
        _model.setMedien(medien);
    }

    @Test
    public void testeLeereMedienListe() throws Exception
    {
        MedienverwaltungMedienTableModel leeresTableModel = new MedienverwaltungMedienTableModel();
        // erwartet: es gibt trotzdem alle Spalten, aber keine Zeilen
        assertEquals(2, leeresTableModel.getColumnCount());
        assertEquals(0, leeresTableModel.getRowCount());
    }

    @Test
    public void testeMedienMitZeilenVerknuepft() throws Exception
    {
        assertTrue(_model.zeileExistiert(0));
        assertEquals(_cd1, _model.getMediumFuerZeile(0));
        assertTrue(_model.zeileExistiert(1));
        assertEquals(_cd3, _model.getMediumFuerZeile(1));
        assertTrue(_model.zeileExistiert(2));
        assertEquals(_cd2, _model.getMediumFuerZeile(2));
    }

    @Test
    public void testeSpaltenDefinition() throws Exception
    {
        assertEquals(2, _model.getColumnCount());
        assertEquals("Medientyp", _model.getColumnName(0));
        assertEquals("Titel", _model.getColumnName(1));
        assertEquals(String.class, _model.getColumnClass(0));
        assertEquals(String.class, _model.getColumnClass(1));
    }

    @Test
    public void testeWerte() throws Exception
    {
        assertEquals("CD", _model.getValueAt(0, 0));
        assertEquals("CD1-Titel", _model.getValueAt(0, 1));
        assertEquals("CD", _model.getValueAt(1, 0));
        assertEquals("CD1-Titel", _model.getValueAt(1, 1));
        assertEquals("CD", _model.getValueAt(2, 0));
        assertEquals("CD2-Titel", _model.getValueAt(2, 1));
    }

    @Test
    public void testeZeilenAnzahl() throws Exception
    {
        assertEquals(3, _model.getRowCount());
    }
}
