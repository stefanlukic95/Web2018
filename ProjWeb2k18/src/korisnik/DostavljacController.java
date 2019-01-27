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

@Path("/Dostavljac")
public class DostavljacController {
	DostavljacService service = new DostavljacService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dostavljac> getDostavlajci() throws JsonParseException, JsonMappingException, IOException {
        return service.getDostavljaci();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getDostavljac(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getDostavljac(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addDostavljac(Dostavljac administrator) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createDostavljac(administrator);
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateDostavljac(Dostavljac dostavljac, @PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.updateDostavljac(dostavljac);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteDostavlajc(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteDostavljac(id);
    }
}
