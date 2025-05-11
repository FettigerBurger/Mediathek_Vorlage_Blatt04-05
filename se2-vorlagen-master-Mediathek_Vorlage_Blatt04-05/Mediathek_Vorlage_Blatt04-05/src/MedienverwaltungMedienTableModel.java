import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Ein MedienverwaltungMedienTableModel hält Medien. Es sieht zwei Spalten vor:
 * Medientyp und Titel.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class MedienverwaltungMedienTableModel extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private static final String[] COLUMN_NAMES = new String[] { "Medientyp",
            "Titel" };

    private List<Medium> _medienListe;

    /**
     * Initialisiert ein MedienverwaltungMedienTableModel.
     */
    public MedienverwaltungMedienTableModel()
    {
        _medienListe = new ArrayList<Medium>();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public int getColumnCount()
    {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column)
    {
        return COLUMN_NAMES[column];
    }

    @Override
    public int getRowCount()
    {
        return _medienListe.size();
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        Medium medium = _medienListe.get(row);
        Object ergebnis = null;
        switch (column)
        {
        case 0:
            ergebnis = medium.getMedienBezeichnung();
            break;
        case 1:
            ergebnis = medium.getTitel();
            break;
        }
        return ergebnis;
    }

    /**
     * Liefert ein Medium, das in der Zeile mit einer gegebenen Nummer
     * dargestellt wird.
     * 
     * @param zeile Eine Nummer einer Tabellenzeile
     * 
     * @require zeileExistiert(zeile)
     */
    public Medium getMediumFuerZeile(int zeile)
    {
        assert zeileExistiert(zeile) : "Vorbedingung verletzt: zeileExistiert(zeile)";
        return _medienListe.get(zeile);
    }

    /**
     * Prüft, ob für die gegebene Tabellen-Zeile ein Medium in dem TableModel
     * existiert.
     * 
     * @param zeile Die Nummer der Tabellenzeile
     */
    public boolean zeileExistiert(int zeile)
    {
        boolean result = false;
        if ((zeile < _medienListe.size()) && (zeile >= 0))
        {
            result = true;
        }
        return result;
    }

    /**
     * Setze die anzuzeigenden Medien. Nach dem Setzen wird die Tabelle
     * aktualisiert. Es wird auf einer Kopie der Liste gearbeitet.
     * 
     * @require medien != null
     */
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: medien != null";
        _medienListe = new ArrayList<Medium>(medien);

        // sortiere Medien-Liste
        Collections.sort(_medienListe, new MedienComparator());

        fireTableDataChanged();
    }

}
