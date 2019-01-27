package artikal;

public class Artikal {
	public static enum Tip {PICE,JELO}
		private String id;
	    private  String naziv;
	    private int cena;
	    private  String opis;
	    private String kolicina;
	    private Tip tip;
	    //Artikal treba da sadrzi tip koji moze biti jelo/pice!
	    private boolean deleted;
	    private String restoranId;

	    public Artikal(){
	    }

	    public Artikal(String id, String naziv, int cena, String opis, String kolicina,Tip tip,boolean deleted,String restoranId) {
	        this.id = id;
	        this.naziv = naziv;
	        this.cena = cena;
	        this.opis = opis;
	        this.kolicina = kolicina;
	        this.tip = tip;
	        this.deleted = deleted;
	        this.restoranId = restoranId;
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

	    public int getCena() {
	        return cena;
	    }

	    public void setCena(int cena) {
	        this.cena = cena;
	    }

	    public String getOpis() {
	        return opis;
	    }

	    public void setOpis(String opis) {
	        this.opis = opis;
	    }

	    public String getKolicina() {
	        return kolicina;
	    }

	    public void setKolicina(String kolicina) {
	        this.kolicina = kolicina;
	    }

	 

		public Tip getTip() {
			return tip;
		}

		public void setTip(Tip tip) {
			this.tip = tip;
		}

		public boolean isDeleted() {
			return deleted;
		}

		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}

		public String getRestoranId() {
			return restoranId;
		}

		public void setRestoranId(String restoranId) {
			this.restoranId = restoranId;
		}
		
	    
}
