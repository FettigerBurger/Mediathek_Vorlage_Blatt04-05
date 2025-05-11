import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Ein KundenDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Kunden
 * anzuzeigen.
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class KundenDetailAnzeigerWerkzeug
{
    private KundenDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues KundenDetailAnzeigerWerkzeug.
     */
    public KundenDetailAnzeigerWerkzeug()
    {
        _ui = new KundenDetailAnzeigerUI();
    }

    /**
     * Setzt den Kunden, dessen Details angezeigt werden sollen.
     * 
     * @param kunde Ein Kunde, oder null um die Detailanzeige zu leeren.
     * 
     */
    public void setKunde(Kunde kunde)
    {
        JTextArea selectedKundenTextArea = _ui.getKundenAnzeigerTextArea();
        selectedKundenTextArea.setText("");
        if (kunde != null)
        {
            selectedKundenTextArea.append(kunde.getFormatiertenString());
        }
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
