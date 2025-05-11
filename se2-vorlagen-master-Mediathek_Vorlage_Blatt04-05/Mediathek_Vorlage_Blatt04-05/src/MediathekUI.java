import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Das Hauptfenster für die Anwendung
 * 
 * @author SE2-Team
 * @version SoSe 2021
 */
class MediathekUI
{
    // Die Bezeichner der Buttons, werden auch als Schlüssel für das CardLayout
    // verwendet.
    public static final String AUSLEIHE = "Ausleihe-Ansicht";
    public static final String RUECKGABE = "Rückgabe-Ansicht";
    public static final String NAME = "SE2-Mediathek Blatt 04-05";

    private JButton _ausleiheButton;
    private JPanel _ausleihePanel;
    private JPanel _menuPanel;
    private CardLayout _anzeigeLayout;
    private JPanel _anzeigePanel;

    private JButton _rueckgabeButton;
    private JPanel _rueckgabePanel;

    private JPanel _spacerPanel;
    private JLabel _titelLabel;

    private JFrame _frame;

    /**
     * Initialisiert die Oberfläche der Mediathek
     * 
     * @param ausleihePanel Das Panel der Ausleihe.
     * @param rueckgabePanel Das Panel der Rueckgabe.
     * 
     * @require ausleihePanel != null
     */
    public MediathekUI(JPanel ausleihePanel, JPanel rueckgabePanel)
    {
        assert ausleihePanel != null : "Vorbedingung verletzt: ausleihePanel != null";
        assert rueckgabePanel != null : "Vorbedingung verletzt: rueckgabePanel != null";
        _ausleihePanel = ausleihePanel;
        _rueckgabePanel = rueckgabePanel;
        initGUI();
    }

    /**
     * Erzeugt das Anzeige-Panel, in dem die Panels für die verschiedenen
     * Ansichten (wie beispielsweise das Rückgabe-Panel) über ein CardLayout
     * angezeigt und versteckt werden können.
     * 
     * Fügt die Panels für die verschiedenen Ansichten in das Anzeige-Panel ein.
     */
    private void erzeugeAnzeigePanel()
    {
        _anzeigePanel = new JPanel();
        _anzeigeLayout = new CardLayout();
        _anzeigePanel.setLayout(_anzeigeLayout);

        // Beim CardLayout wird jeweils das Widget und ein Schlüssel übergeben.
        // Beispiel: Widget = _ausleihePanel. Schlüssel = AUSLEIHE.
        _anzeigePanel.add(_ausleihePanel, AUSLEIHE);
        _anzeigePanel.add(_rueckgabePanel, RUECKGABE);
        _frame.getContentPane().add(_anzeigePanel, BorderLayout.CENTER);
    }

    /**
     * Erzeugt den Ausleih-Button für das Menü
     */
    private void erzeugeAusleiheButton()
    {
        _ausleiheButton = new JButton();
        initialisiereMenuButton(_ausleiheButton, AUSLEIHE);
        _ausleiheButton.setSelected(true);
    }

    /**
     * Erzeugt den Rückgabe-Button für das Menü.
     */
    private void erzeugeRueckgabeButton()
    {
        _rueckgabeButton = new JButton();
        initialisiereMenuButton(_rueckgabeButton, RUECKGABE);
    }

    /**
     * Erzeugt das Menü mit Ausleih- und Rückgabe-Button und Titel.
     */
    private void erzeugeMenuPanel()
    {
        _menuPanel = new JPanel();
        FlowLayout auswahlPanelLayout = new FlowLayout();
        auswahlPanelLayout.setAlignment(FlowLayout.LEFT);
        _menuPanel.setLayout(auswahlPanelLayout);
        _frame.getContentPane().add(_menuPanel, BorderLayout.NORTH);
        _menuPanel.setBackground(UIConstants.BACKGROUND_COLOR);
        erzeugeAusleiheButton();
        erzeugeRueckgabeButton();
        erzeugeTitel();
    }

    /**
     * Initialisiert einen Menü-Button.
     * 
     * @param button Der Button.
     * @param buttonText Der Text der auf dem Button stehen soll.
     */
    private void initialisiereMenuButton(JButton button, String buttonText)
    {
        _menuPanel.add(button);
        button.setText(buttonText);
        button.setPreferredSize(new java.awt.Dimension(180, 50));
        button.setFont(UIConstants.BUTTON_FONT);
        button.setBackground(UIConstants.BUTTON_COLOR);
    }

    /**
     * Erzeugt den Titel für das Menü.
     */
    private void erzeugeTitel()
    {
        _spacerPanel = new JPanel();
        _menuPanel.add(_spacerPanel);
        _spacerPanel.setPreferredSize(new java.awt.Dimension(100, 10));
        _spacerPanel.setBackground(UIConstants.BACKGROUND_COLOR);

        _titelLabel = new JLabel();
        _menuPanel.add(_titelLabel);
        _titelLabel.setText(NAME);
        _titelLabel.setBackground(UIConstants.BACKGROUND_COLOR);
        _titelLabel.setFont(UIConstants.TITLE_FONT);
        _titelLabel.setForeground(UIConstants.TITLE_COLOR);
    }

    /**
     * Initialisiert die GUI, setze das Layout, füge die Widget ein, setze
     * Listener, die auf Benutzeraktionen reagieren.
     */
    private void initGUI()
    {
        _frame = new JFrame(NAME);
        _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        _frame.getContentPane().setBackground(UIConstants.BACKGROUND_COLOR);
        _frame.setTitle(NAME);
        erzeugeAnzeigePanel();
        erzeugeMenuPanel();
        _frame.pack();
        _frame.setSize(1100, 768);
        zeigeAn(AUSLEIHE);
    }

    /**
     * Aktualisiert das Layout.
     */
    private void aktualisiereLayout()
    {
        _frame.validate();
    }

    /**
     * Zeigt das Werkzeug mit dem angebenen Namen.
     * 
     * @param werkzeugName Der Name eines Werkzeugs.
     * 
     * @require werkzeugName != null
     */
    private void zeigeAn(String werkzeugName)
    {
        assert werkzeugName != null : "Vorbedingung verletzt: werkzeugName != null";
        _anzeigeLayout.show(_anzeigePanel, werkzeugName);
        JButton buttonToSelect;
        JButton buttonToDeselect;
        if (werkzeugName.equals(AUSLEIHE))
        {
            buttonToSelect = getAusleiheButton();
            buttonToDeselect = getSelectedButton();
        }
        else if (werkzeugName.equals(RUECKGABE))
        {
            buttonToSelect = getRueckgabeButton();
            buttonToDeselect = getSelectedButton();
        }
        else
        {
            throw new IllegalArgumentException("Werkzeugname unbekannt: "
                    + werkzeugName);
        }
        buttonToDeselect.setSelected(false);
        buttonToDeselect.setBackground(UIConstants.BUTTON_COLOR);
        buttonToSelect.setSelected(true);
        buttonToSelect.setBackground(UIConstants.BUTTON_SELECTED_COLOR);
        aktualisiereLayout();
    }

    /**
     * Gibt den aktuell selektierten Menu-Button urück.
     * 
     * @return Den aktuell selektierten Menu-Button.
     */
    private JButton getSelectedButton()
    {
        JButton result = _ausleiheButton;
        for (int i = 0; i < _menuPanel.getComponentCount(); i++)
        {
            Component component = _menuPanel.getComponent(i);
            if (component instanceof JButton)
            {
                JButton button = (JButton) component;
                if (button.isSelected())
                {
                    result = button;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Gibt den Ausleihe-Button zurück.
     * 
     * @return Den Ausleihe-Button.
     */
    public JButton getAusleiheButton()
    {
        return _ausleiheButton;
    }

    /**
     * Gibt den Rueckgabe-Button zurück.
     * 
     * @return Den Rueckgabe-Button.
     */
    public JButton getRueckgabeButton()
    {
        return _rueckgabeButton;
    }

    /**
     * Gibt das JFrame der UI zurück.
     * 
     * @return Das JFrame der UI.
     */
    public JFrame getUIFrame()
    {
        return _frame;
    }

    /**
     * Zeigt die Ausleihe-Sicht
     */
    public void zeigeAusleihe()
    {
        zeigeAn(MediathekUI.AUSLEIHE);
    }

    /**
     * Zeigt die Rückgabe-Sicht
     */
    public void zeigeRueckgabe()
    {
        zeigeAn(MediathekUI.RUECKGABE);
    }

    /**
     * Zeigt das Mediathek-Hauptfenster an.
     */
    public void zeigeFenster()
    {
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
    }
}
