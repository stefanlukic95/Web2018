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

@Path("/Administrator")
public class AdministratorController {
	AdministratorService service = new AdministratorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Administrator> getKorisnici() throws JsonParseException, JsonMappingException, IOException {
        return service.getAdmini();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getAdministrator(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getAdmin(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Administrator addADministrator(Administrator administrator) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createAdmin(administrator);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteAdministrator(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteAdmin(id);
    }
}
