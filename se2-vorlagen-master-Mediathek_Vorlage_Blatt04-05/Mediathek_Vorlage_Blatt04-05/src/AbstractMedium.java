
public abstract class AbstractMedium implements Medium
{
    /**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     */
    private String _titel;

    /**
     * Initialisiert ein neues Medium.
     * 
     * @param titel Der Titel des Mediums
     * @param kommentar Ein Kommentar zum Medium
     * 
     * @require titel != null
     * @require kommentar != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     */
    protected AbstractMedium(String kommentar, String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";

        _titel = titel;
        _kommentar = kommentar;
    }

    public abstract String getMedienBezeichnung();

    @Override
    public String toString()
    {
        return getFormatiertenString();
    }

    public String getFormatiertenString()
    {
        return getMedienBezeichnung() + ":\n" + "    " + "Titel: " + _titel
                + "\n" + "    " + "Kommentar: " + _kommentar;
    }

    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    /**
     * Ändert den Kommentar
     * 
     * @param kommentar Ein Kommentar zum Medium
     * 
     * @require kommentar != null
     * @ensure getKommentar() == kommentar
     */
    @Override
    public void setKommentar(String kommentar)
    {
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _kommentar = kommentar;
    }

    @Override
    public String getTitel()
    {
        return _titel;
    }

    /**
     * Ändert den Titel
     * 
     * @param titel Der Titel des Mediums
     * 
     * @require titel != null
     * @ensure getTitel() == titel
     */
    @Override
    public void setTitel(String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        _titel = titel;
    }

    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Die Mietdauer muss größer als 0 sein";
        int gebuehr = mietTage * 300;

        return new Geldbetrag(gebuehr);
    }
}
