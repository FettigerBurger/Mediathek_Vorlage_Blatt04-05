import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Ein MedienverwaltungMedienauflisterWerkzeug ist ein Werkzeug zum Auflisten
 * von Medien.
 * 
 * Das Werkzeug ist beobachtbar und informiert darüber, wenn sich die Selektion
 * in der Medienliste ändert.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class MedienverwaltungMedienauflisterWerkzeug extends ObservableSubWerkzeug
{
    private MedienverwaltungMedienauflisterUI _ui;
    private MedienbestandService _medienbestand;

    /**
     * Initialisiert ein neues MedienverwaltungMedienauflisterWerkzeug. Es wird
     * die Benutzungsoberfläche zum Darstellen der Medien erzeugt.
     * 
     * @param medienbestand Der Medienbestand.
     * 
     * @require medienbestand != null
     */
    public MedienverwaltungMedienauflisterWerkzeug(
            MedienbestandService medienbestand)
    {
        assert medienbestand != null : "Vorbedingung verletzt: medienbestand != null";

        _medienbestand = medienbestand;

        // UI wird erzeugt.
        _ui = new MedienverwaltungMedienauflisterUI();

        // Die Ausleihaktionen werden erzeugt und an der UI registriert.
        registriereUIAktionen();

        // Die Beobachter werden erzeugt und an den Servies registriert.
        registriereServiceBeobachter();

        // Die anzuzeigenden Kunden werden in den UI-Widgets gesetzt.
        setzeAnzuzeigendeMedien();
    }

    /**
     * Registriert die Aktionen, die bei bestimmten UI-Events ausgeführt werden.
     */
    private void registriereUIAktionen()
    {
        registriereMedienAnzeigenAktion();
    }

    /**
     * Holt die Medieninformationen aus dem Service und setzt sie in der UI.
     */
    private void setzeAnzuzeigendeMedien()
    {
        _ui.getMedienAuflisterTableModel()
                .setMedien(_medienbestand.getMedien());
    }

    /**
     * Registriert die Aktion, die ausgeführt wird, wenn ein Medium ausgewählt
     * wird.
     */
    private void registriereMedienAnzeigenAktion()
    {
        _ui.getMedienAuflisterTable().getSelectionModel()
                .addListSelectionListener(new ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        informiereUeberAenderung();
                    }
                });
    }

    /**
     * Registriert die Beobacheter für die Services.
     */
    private void registriereServiceBeobachter()
    {
        ServiceObserver beobachter = new ServiceObserver()
        {
            @Override
            public void informiereUeberAenderung()
            {
                // Wenn der Medienbestand-Service eine Änderung mitteilt, dann
                // wird
                // die angezeigte Liste aller Medien aktualisiert:
                setzeAnzuzeigendeMedien();
            }
        };
        _medienbestand.registriereBeobachter(beobachter);
    }

    /**
     * Gibt das vom Benutzer selektierte Medium zurück.
     * 
     * @return Das vom Benutzer selektierte Medium oder null, wenn nichts
     *         selektiert ist.
     * 
     */
    public Medium getSelectedMedium()
    {
        Medium result = null;

        int selectedRow = _ui.getMedienAuflisterTable().getSelectedRow();
        MedienverwaltungMedienTableModel medienverwaltungMedienTableModel = _ui
                .getMedienAuflisterTableModel();
        if (medienverwaltungMedienTableModel.zeileExistiert(selectedRow))
        {
            result = medienverwaltungMedienTableModel
                    .getMediumFuerZeile(selectedRow);
        }
        return result;
    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
    }
}
