import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

/**
 * MedienverwaltungMedienauflisterUI beschreibt die grafische
 * Benutzungsoberfläche für das MedienverwaltungMedienauflisterWerkzeug.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class MedienverwaltungMedienauflisterUI
{
    private MedienverwaltungMedienTableModel _ausleiheMedienTableModel;
    private JPanel _hauptPanel;
    private JTable _medienTable;

    /**
     * Initialisiert eine neue MedienverwaltungMedienauflisterUI.
     */
    public MedienverwaltungMedienauflisterUI()
    {
        erzeugeHauptPanel();
        erzeugeMedienTable();
    }

    /**
     * Ereugt das Haupt-Panel.
     */
    private void erzeugeHauptPanel()
    {
        _hauptPanel = new JPanel(new BorderLayout());
    }

    /**
     * Erzeugt die Tabelle für die Anzeige der Medien.
     */
    private void erzeugeMedienTable()
    {
        JScrollPane medienAuflisterScrollPane = new JScrollPane();
        medienAuflisterScrollPane.setBorder(BorderFactory.createTitledBorder(
                null, "Medien", TitledBorder.LEADING,
                TitledBorder.DEFAULT_POSITION, UIConstants.HEADER_FONT));
        medienAuflisterScrollPane.setBackground(UIConstants.BACKGROUND_COLOR);
        medienAuflisterScrollPane.getVerticalScrollBar().setBackground(
                UIConstants.BACKGROUND_COLOR);
        medienAuflisterScrollPane.getHorizontalScrollBar().setBackground(
                UIConstants.BACKGROUND_COLOR);

        _ausleiheMedienTableModel = new MedienverwaltungMedienTableModel();
        _medienTable = new JTable();
        _medienTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medienAuflisterScrollPane.setViewportView(_medienTable);
        _medienTable.setModel(_ausleiheMedienTableModel);
        JTableHeader tableHeader = _medienTable.getTableHeader();
        tableHeader.setFont(UIConstants.HEADER_FONT);
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
        _medienTable.setFont(UIConstants.TEXT_FONT);

        _hauptPanel.add(medienAuflisterScrollPane, BorderLayout.CENTER);
    }

    /**
     * Gibt die Medienauflistertabelle (JTable) zurück.
     * 
     * @ensure result != null
     */
    public JTable getMedienAuflisterTable()
    {
        return _medienTable;
    }

    /**
     * Gibt das MedienverwaltungMedienTableModel der UI zurück.
     * 
     * @ensure result != null
     */
    public MedienverwaltungMedienTableModel getMedienAuflisterTableModel()
    {
        return _ausleiheMedienTableModel;
    }

    /**
     * Gibt das Haupt-Panel der UI zurück.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _hauptPanel;
    }
}
