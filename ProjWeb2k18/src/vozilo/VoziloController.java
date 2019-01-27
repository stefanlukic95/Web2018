package vozilo;

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

@Path("/Vozilo")
public class VoziloController {
	VoziloService service = new VoziloService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vozilo> getVozila() throws JsonParseException, JsonMappingException, IOException {
        return service.getVozila();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getVozilo(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getVozilo(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addVozilo(Vozilo article) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createVozilo(article);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object updateVozilo(Vozilo article, @PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.updateVozilo(article);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteVozilo(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteVozilo(id);
    }
   
}
