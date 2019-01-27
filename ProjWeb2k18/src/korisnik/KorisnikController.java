package korisnik;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import artikal.Artikal;
import artikal.ArtikalService;

@Path("/Korisnik")
public class KorisnikController {
	KorisnikService service = new KorisnikService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Korisnik> getKorisnici() throws JsonParseException, JsonMappingException, IOException {
        return service.getKorisnici();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getKorisnik(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getKorisnik(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addKorisnik(Korisnik korisnik) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createKorisnik(korisnik);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object updateArticle(Korisnik korisnik, @PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.updateKorisnik(korisnik);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteKorisnik(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteKorisnik(id);
    }
}
