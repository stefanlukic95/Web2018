package artikal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import restoran.Restoran;
import restoran.RestoranService;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArtikalService {
	private ObjectMapper mapper;
	private File artikalFile;
	private RestoranService restoranService;
	
	
	public ArtikalService() {
		this.mapper = new ObjectMapper();
		this.artikalFile = new File(this.getClass().getClassLoader().getResource("/podaci/Artikal.json").getPath());
	}
	
	public ArrayList<Artikal> getArtikli() throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(artikalFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Artikal.class));
	}
	
	public Artikal getArtikal(String id) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Artikal> restorani = getArtikli();
		for(Artikal i: restorani) {
			if(i.getId().equals(id)) {
				return i;
			}	
		}
		return null;
	}
	public Artikal createArtikal(Artikal restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Artikal> restorani = getArtikli();
		
		restorani.add(restoran);
		mapper.writeValue(artikalFile, restorani);
		return restoran;
	}
	
	
	
	public boolean deleteArtikal(String id) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Artikal> restorani = getArtikli();
		Artikal restoran = null;
		int index = -1;
		
		for(Artikal i: restorani) {
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
	
	public boolean updateArtikal(Artikal restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Artikal> restorani = getArtikli();
		Artikal restoranUpdate = null;
		int index = -1;
		
		for(Artikal i: restorani) {
			if(i.getId().equals(restoran.getId())) {
				index = restorani.indexOf(i);
			}
		}

		restoranUpdate = restorani.get(index);
		restoranUpdate.setNaziv(restoran.getNaziv());
		restoranUpdate.setCena(restoran.getCena());
		restoranUpdate.setOpis(restoran.getOpis());
		restoranUpdate.setKolicina(restoran.getKolicina());
		restoranUpdate.setTip(restoran.getTip());
		restoranUpdate.setDeleted(restoran.isDeleted());
		
		mapper.writeValue(artikalFile, restorani);
		
		return true;	
	}
	
	public List<Artikal> searchArtikli(Artikal.Tip tip, int cena, String naziv, String nazivRestorana) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<Artikal> allItems = getArtikli();
		
		Restoran artikalRestoran = this.restoranService.getRestaurantByName(nazivRestorana);
	
		return allItems.stream()
				.filter((artikal)->artikal.getTip().equals(tip))
				.filter((artikal)->artikal.getCena()==cena)
				.filter((artikal)->artikal.getNaziv().equals(naziv))
				.filter((artikal)->artikal.getRestoranId()==artikalRestoran.getId())
				.collect(Collectors.toCollection(ArrayList::new));
				
				
	}
}
