package porudzbina;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import korisnik.DostavljacService;
import korisnik.KorisnikService;


@Path("/Porudzbina")
public class PorudzbinaController {
	PorudzbinaService service = new PorudzbinaService();
	KorisnikService korisnikServce = new KorisnikService();
	DostavljacService dostavljacService = new DostavljacService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Porudzbina> getPorudzbine() throws JsonParseException, JsonMappingException, IOException {
        return service.getPorudzbine();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getPorudzbina(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getPorudzbina(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addPorudzbina(Porudzbina porudzbina) throws JsonGenerationException, JsonMappingException, IOException {
    	
        return service.createPorudzbina(porudzbina);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deletPorudzbina(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deletePorudzbina(id);
    }
}
