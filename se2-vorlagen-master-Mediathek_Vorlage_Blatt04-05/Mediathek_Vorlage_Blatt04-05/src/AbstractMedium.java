
public abstract class AbstractMedium implements Medium
{
    /**
     * Ein Kommentar zum Medium
     */
    protected String _kommentar;

    /**
     * Der Titel des Mediums
     */
    protected String _titel;

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
    public AbstractMedium(String kommentar, String titel)
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

    public abstract String getFormatiertenString();

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
}
