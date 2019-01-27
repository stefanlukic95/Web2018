package porudzbina;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vozilo.Vozilo;



import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PorudzbinaService {
	private ObjectMapper mapper;
	private File artikalFile;
	
	public PorudzbinaService() {
		this.mapper = new ObjectMapper();
		this.artikalFile = new File(this.getClass().getClassLoader().getResource("/podaci/Porudzbina.json").getPath());
	}
	
	public ArrayList<Porudzbina> getPorudzbine() throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(artikalFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Porudzbina.class));
	}
	
	public Porudzbina getPorudzbina(String id) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Porudzbina> restorani = getPorudzbine();
		for(Porudzbina i: restorani) {
			if(i.getId().equals(id)) {
				return i;
			}	
		}
		return null;
	}
	public Porudzbina createPorudzbina(Porudzbina restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Porudzbina> restorani = getPorudzbine();
		
		restorani.add(restoran);
		mapper.writeValue(artikalFile, restorani);
		return restoran;
	}
	
	
	
	public boolean deletePorudzbina(String id) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Porudzbina> restorani = getPorudzbine();
		Porudzbina restoran = null;
		int index = -1;
		
		for(Porudzbina i: restorani) {
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
	
	public boolean updatePorudzbina(Porudzbina restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Porudzbina> restorani = getPorudzbine();
		Porudzbina restoranUpdate = null;
		int index = -1;
		
		for(Porudzbina i: restorani) {
			if(i.getId().equals(restoran.getId())) {
				index = restorani.indexOf(i);
			}
		}

		restoranUpdate = restorani.get(index);
		restoranUpdate.setDeleted(restoran.isDeleted());
		restoranUpdate.setBr_porcija(restoran.getBr_porcija());
		restoranUpdate.setDatum_porudzbine(restoran.getDatum_porudzbine());
		restoranUpdate.setDostavljac(restoran.getDostavljac());
		restoranUpdate.setKupac(restoran.getKupac());
		restoranUpdate.setNapomena(restoran.getNapomena());
		restoranUpdate.setStatus_porudzbine(restoran.getStatus_porudzbine());
		restoranUpdate.setStavka(restoran.getStavka());
		
		mapper.writeValue(artikalFile, restorani);
		
		return true;	
	}
}
