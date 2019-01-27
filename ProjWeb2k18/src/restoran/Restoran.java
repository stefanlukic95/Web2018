package restoran;

import java.util.List;

import artikal.Artikal;


public class Restoran {
	
	public static enum Kategorija {DOMACAKUHINJA,ROSTILJ,KINESKI,INDIJSKI,POSLASTICARNICA,PICERIJA};
	
	private String id;
    private String naziv;
    private String adresa;
    private Kategorija kategorija;
    private List<String> artikal;
   
    private boolean deleted;

    public Restoran(){

    }
    

    public Restoran(String id, String naziv, String adresa,List<String> artikal, Kategorija kategorija,boolean deleted) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.artikal = artikal;
       
        this.kategorija = kategorija;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

   
	public List<String> getArtikal() {
		return artikal;
	}


	public void setArtikal(List<String> artikal) {
		this.artikal = artikal;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
    
}
