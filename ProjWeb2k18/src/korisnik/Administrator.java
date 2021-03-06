package korisnik;

public class Administrator {

    private String id;
    private String korisnicko_ime;
    private String lozinka;
    private String ime;
    private String prezime;
    //uloga moze biti kupac, administrator ili dostavljac
    private String uloga;
    private String kontakt_telefon;
    private String e_mail;
    private String datum_registracije;
    private boolean deleted;

    public Administrator(){

    }
    public Administrator(String id, String korisnicko_ime, String lozinka, String ime, String prezime, String uloga, String kontakt_telefon, String e_mail, String datum_registracije,boolean deleted) {
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = "ADMINISTRATOR";
        this.kontakt_telefon = kontakt_telefon;
        this.e_mail = e_mail;
        this.datum_registracije = datum_registracije;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getKontakt_telefon() {
        return kontakt_telefon;
    }

    public void setKontakt_telefon(String kontakt_telefon) {
        this.kontakt_telefon = kontakt_telefon;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getDatum_registracije() {
        return datum_registracije;
    }

    public void setDatum_registracije(String datum_registracije) {
        this.datum_registracije = datum_registracije;
    }
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
    
    
}
