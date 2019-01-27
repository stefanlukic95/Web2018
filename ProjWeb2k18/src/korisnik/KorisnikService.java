package korisnik;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KorisnikService {
	private ObjectMapper mapper;
	private File artikalFile;
	
	public KorisnikService() {
		this.mapper = new ObjectMapper();
		this.artikalFile = new File(this.getClass().getClassLoader().getResource("/podaci/Korisnik.json").getPath());
	}
	
	public ArrayList<Korisnik> getKorisnici() throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(artikalFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Korisnik.class));
	}
	
	public Korisnik getKorisnik(String id) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Korisnik> restorani = getKorisnici();
		for(Korisnik i: restorani) {
			if(i.getId().equals(id)) {
				return i;
			}	
		}
		return null;
	}
	public Korisnik createKorisnik(Korisnik restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Korisnik> restorani = getKorisnici();
		
		restorani.add(restoran);
		mapper.writeValue(artikalFile, restorani);
		return restoran;
	}
	
	
	
	public boolean deleteKorisnik(String id) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Korisnik> restorani = getKorisnici();
		Korisnik restoran = null;
		int index = -1;
		
		for(Korisnik i: restorani) {
			if(i.getId().equals(id)) {
				index = restorani.indexOf(i);
			}
		}
		
		if(index == -1) {
			return false;
		}
		
		restoran = restorani.get(index);
		restoran.setDeleted(true);
		restorani.set(index, restoran);
		mapper.writeValue(artikalFile, restorani);
		
		return true;
	}
	
	public boolean updateKorisnik(Korisnik restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Korisnik> restorani = getKorisnici();
		Korisnik restoranUpdate = null;
		int index = -1;
		
		for(Korisnik i: restorani) {
			if(i.getId().equals(restoran.getId())) {
				index = restorani.indexOf(i);
			}
		}

		restoranUpdate = restorani.get(index);
		restoranUpdate.setKorisnicko_ime(restoran.getKorisnicko_ime());
		restoranUpdate.setE_mail(restoran.getE_mail());
		restoranUpdate.setDatum_registracije(restoran.getDatum_registracije());
		restoranUpdate.setIme(restoran.getIme());
		restoranUpdate.setDeleted(restoran.isDeleted());
		restoranUpdate.setKontakt_telefon(restoran.getKontakt_telefon());
		restoranUpdate.setLozinka(restoran.getLozinka());
		restoranUpdate.setPrezime(restoran.getPrezime());
		restoranUpdate.setUloga(restoran.getUloga());
		restoranUpdate.setOmiljeni_restoran(restoran.getOmiljeni_restoran());
		restoranUpdate.setPorudzbina_kupca(restoran.getPorudzbina_kupca());
	
		
		
		mapper.writeValue(artikalFile, restorani);
		
		return true;	
	}

}
