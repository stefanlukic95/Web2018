package vozilo;

public class Vozilo {
	
	public static enum TipVozila {BICIKL,SKUTER,AUTOMOBIL};
    private String id;
    private String marka;
    private String model;
    private TipVozila tip;
    private String registarska_oznaka;
    private String godina_proizvodnje;
    private String upotreba;
    private String napomena;
    private boolean deleted;

    public Vozilo(){

    }

    public Vozilo(String id, String marka, String model, TipVozila tip, String registarska_oznaka, String godina_proizvodnje, String upotreba, String napomena,boolean deleted) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.tip = tip;
        this.registarska_oznaka = registarska_oznaka;
        this.godina_proizvodnje = godina_proizvodnje;
        this.upotreba = upotreba;
        this.napomena = napomena;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TipVozila getTip() {
        return tip;
    }

    public void setTip(TipVozila tip) {
        this.tip = tip;
    }

    public String getRegistarska_oznaka() {
        return registarska_oznaka;
    }

    public void setRegistarska_oznaka(String registarska_oznaka) {
        this.registarska_oznaka = registarska_oznaka;
    }

    public String getGodina_proizvodnje() {
        return godina_proizvodnje;
    }

    public void setGodina_proizvodnje(String godina_proizvodnje) {
        this.godina_proizvodnje = godina_proizvodnje;
    }

    public String getUpotreba() {
        return upotreba;
    }

    public void setUpotreba(String upotreba) {
        this.upotreba = upotreba;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
    
}
