package korisnik;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import porudzbina.Porudzbina;
import restoran.Restoran;


public class Korisnik {
	
	
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

    private  List<String> porudzbina_kupca;
    private  List<String> omiljeni_restoran;
    
    private boolean deleted;

    private SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public Korisnik(){
    	
    }
    


    public Korisnik(String id, String korisnicko_ime, String lozinka, String ime, String prezime, String uloga, String kontakt_telefon,String e_mail, String datum_registracije,List<String> porudzbina_kupca,List<String> omiljeni_restoran,boolean deleted) {
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = "KORISNIK";
        this.kontakt_telefon = kontakt_telefon;
        this.e_mail = e_mail;
        this.porudzbina_kupca = porudzbina_kupca;
        this.omiljeni_restoran = omiljeni_restoran;
        this.datum_registracije = simpleDate.format(new Date());
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

   public List<String> getPorudzbina_kupca() {
        return porudzbina_kupca;
    }

    public void setPorudzbina_kupca(List<String> porudzbina_kupca) {
        this.porudzbina_kupca = porudzbina_kupca;
    }

    public List<String> getOmiljeni_restoran() {
        return omiljeni_restoran;
    }

    public void setOmiljeni_restoran(List<String> string) {
        this.omiljeni_restoran = string;
    }



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

    
}
