package restoran;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import korisnik.Korisnik;
import korisnik.KorisnikService;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestoranService {
	private ObjectMapper mapper;
	private File restoranFile;
	private KorisnikService korisnikService;
	
	public RestoranService() {
		this.mapper = new ObjectMapper();
		this.restoranFile = new File(this.getClass().getClassLoader().getResource("/podaci/Restoran.json").getPath());
	}
	
	public ArrayList<Restoran> getRestorani() throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(restoranFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Restoran.class));
	}
	
	public Restoran getRestoran(String id) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Restoran> restorani = getRestorani();
		for(Restoran i: restorani) {
			if(i.getId().equals(id)) {
				return i;
			}	
		}
		return null;
	}
	
	public Restoran getRestaurantByName(String name) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<Restoran> restaurants = new ArrayList<Restoran>();
		restaurants = getRestorani();
		
		return restaurants.stream()
				.filter((restaurant)->restaurant.getNaziv().equals(name))
				.findFirst()
				.orElse(null);
	}
	
	public Restoran getRestaurantAdresa(String adresa) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<Restoran> restaurants = new ArrayList<Restoran>();
		restaurants = getRestorani();
		
		return restaurants.stream()
				.filter((restaurant)->restaurant.getAdresa().equals(adresa))
				.findFirst()
				.orElse(null);
	}
	
	public Restoran getRestoranKategorija(String kategorija) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<Restoran> restaurants = new ArrayList<Restoran>();
		restaurants = getRestorani();
		
		return restaurants.stream()
				.filter((restaurant)->restaurant.getKategorija().equals(kategorija))
				.findFirst()
				.orElse(null);
	}
	
	public Restoran createRestoran(Restoran restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Restoran> restorani = getRestorani();
		
		restorani.add(restoran);
		mapper.writeValue(restoranFile, restorani);
		return restoran;
	}
	
	
	
	public boolean deleteRestoran(String id) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Restoran> restorani = getRestorani();
		Restoran restoran = null;
		int index = -1;
		
		for(Restoran i: restorani) {
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
		mapper.writeValue(restoranFile, restorani);
		
		return true;
	}
	
	public boolean updateRestoran(Restoran restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Restoran> restorani = getRestorani();
		Restoran restoranUpdate = null;
		int index = -1;
		
		for(Restoran i: restorani) {
			if(i.getId().equals(restoran.getId())) {
				index = restorani.indexOf(i);
			}
		}
		
		restoranUpdate = restorani.get(index);
		restoranUpdate.setNaziv(restoran.getNaziv());
		restoranUpdate.setAdresa(restoran.getAdresa());
		restoranUpdate.setKategorija(restoran.getKategorija());
		restoranUpdate.setArtikal(restoran.getArtikal());
	
		restoranUpdate.setDeleted(restoran.isDeleted());
		
		mapper.writeValue(restoranFile, restorani);
		
		return true;	
	}
	
	public List<Restoran> getSacuvaniRestorani(String korisnikId) throws JsonParseException, JsonMappingException, IOException{
		Korisnik korisnik = this.korisnikService.getKorisnik(korisnikId);
		ArrayList<String> restoraniId = (ArrayList<String>)korisnik.getOmiljeni_restoran();
		
		ArrayList<Restoran> restaurants = getRestorani();
		ArrayList<Restoran> returnRes = new ArrayList<Restoran>();
		
		for(String id: restoraniId) {
			restaurants.stream()
						.filter((r)->r.getId().equals(id))
						.forEach((r) ->returnRes.add(r));
		}
		return returnRes;
	}
	
	
}
