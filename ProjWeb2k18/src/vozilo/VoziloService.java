package vozilo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import artikal.Artikal;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VoziloService {
	private ObjectMapper mapper;
	private File artikalFile;
	
	public VoziloService() {
		this.mapper = new ObjectMapper();
		this.artikalFile = new File(this.getClass().getClassLoader().getResource("/podaci/Vozilo.json").getPath());
	}
	
	public ArrayList<Vozilo> getVozila() throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(artikalFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Vozilo.class));
	}
	
	public Vozilo getVozilo(String id) throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Vozilo> restorani = getVozila();
		for(Vozilo i: restorani) {
			if(i.getId().equals(id)) {
				return i;
			}	
		}
		return null;
	}
	public Vozilo createVozilo(Vozilo restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Vozilo> restorani = getVozila();
		
		restorani.add(restoran);
		mapper.writeValue(artikalFile, restorani);
		return restoran;
	}
	
	
	
	public boolean deleteVozilo(String id) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Vozilo> restorani = getVozila();
		Vozilo restoran = null;
		int index = -1;
		
		for(Vozilo i: restorani) {
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
	
	public boolean updateVozilo(Vozilo restoran) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Vozilo> restorani = getVozila();
		Vozilo restoranUpdate = null;
		int index = -1;
		
		for(Vozilo i: restorani) {
			if(i.getId().equals(restoran.getId())) {
				index = restorani.indexOf(i);
			}
		}

		restoranUpdate = restorani.get(index);
		restoranUpdate.setDeleted(restoran.isDeleted());
		restoranUpdate.setGodina_proizvodnje(restoran.getGodina_proizvodnje());
		restoranUpdate.setMarka(restoran.getMarka());
		restoranUpdate.setModel(restoran.getModel());
		restoranUpdate.setNapomena(restoran.getNapomena());
		restoranUpdate.setRegistarska_oznaka(restoran.getRegistarska_oznaka());
		restoranUpdate.setTip(restoran.getTip());
		restoranUpdate.setUpotreba(restoran.getUpotreba());
		
		
		mapper.writeValue(artikalFile, restorani);
		
		return true;	
	}


}
