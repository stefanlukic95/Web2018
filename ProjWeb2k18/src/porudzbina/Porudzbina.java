package porudzbina;

import korisnik.Dostavljac;
import korisnik.Korisnik;

public class Porudzbina {
	
		public static enum StatusPorudzbine {PORUCENO, DOSTAVAUTOKU, OTKAZANO, DOSTAVLJENO};
		
	    private String id;
	    private String stavka;
	    private int br_porcija;
	    private String datum_porudzbine;
	    private String kupac;
	    private String dostavljac;
	    //status je inicijalno "poruceno"
	    private StatusPorudzbine status_porudzbine;
	    private String napomena;
	    private boolean deleted;


	    public Porudzbina(){

	    }

	    public Porudzbina(String id, String stavka,int br_porcija, String datum_porudzbine,String kupac, String dostavljac,StatusPorudzbine status_porudzbine, String napomena,boolean deleted) {
	        this.id = id;
	        this.stavka = stavka;
	        this.br_porcija=br_porcija;
	        this.datum_porudzbine = datum_porudzbine;
	        this.kupac = kupac;
	        this.dostavljac = dostavljac;
	        this.status_porudzbine = Porudzbina.StatusPorudzbine.PORUCENO;
	        this.napomena = napomena;
	        this.deleted = deleted;

	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getStavka() {
	        return stavka;
	    }

	    public void setStavka(String stavka) {
	        this.stavka = stavka;
	    }

	    public String getDatum_porudzbine() {
	        return datum_porudzbine;
	    }

	    public void setDatum_porudzbine(String datum_porudzbine) {
	        this.datum_porudzbine = datum_porudzbine;
	    }

	    public String getKupac() {
	        return kupac;
	    }

	    public void setKupac(String kupac) {
	        this.kupac = kupac;
	    }

	    public String getDostavljac() {
	        return dostavljac;
	    }

	    public void setDostavljac(String dostavljac) {
	        this.dostavljac = dostavljac;
	    }

	    public StatusPorudzbine getStatus_porudzbine() {
	        return status_porudzbine;
	    }

	    public void setStatus_porudzbine(StatusPorudzbine status_porudzbine) {
	        this.status_porudzbine = status_porudzbine;
	    }

	    public String getNapomena() {
	        return napomena;
	    }

	    public void setNapomena(String napomena) {
	        this.napomena = napomena;
	    }

	    public int getBr_porcija() {
	        return br_porcija;
	    }

	    public void setBr_porcija(int br_porcija) {
	        this.br_porcija = br_porcija;
	    }

		public boolean isDeleted() {
			return deleted;
		}

		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}
	    
}
