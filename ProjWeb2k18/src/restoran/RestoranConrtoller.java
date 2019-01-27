package restoran;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import artikal.Artikal;
import artikal.ArtikalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import korisnik.Korisnik;
@Path("/Restoran")
public class RestoranConrtoller {
	RestoranService service = new RestoranService();

	@Context
	HttpServletRequest request;
	
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Restoran> getRestorani() throws JsonParseException, JsonMappingException, IOException {
        return service.getRestorani();
    }

   @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getRestoran(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getRestoran(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addRestoran(Restoran restoran) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createRestoran(restoran);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateRestoran(Restoran article, @PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.updateRestoran(article);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteRestoran(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteRestoran(id);
    }
    
	
    @Path("search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchRestaurants( @QueryParam("naziv") String naziv,
									   @QueryParam("adresa") String adresa,
									   @QueryParam("kategorija") String kategorija) {
		Collection<Restoran> restaurants = null;
		Restoran.Kategorija kategorijaRestorana = null;
		try {
			restaurants = this.service.getRestorani();
		}catch(IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		if(naziv != null) {
			restaurants = restaurants.stream()
									 .filter((r)->r.getNaziv().equals(naziv))
									 .collect(Collectors.toCollection(ArrayList::new));
		}
		
		if(adresa != null) {
			restaurants = restaurants.stream()
								    .filter((r)->r.getAdresa().equals(adresa))
								    .collect(Collectors.toCollection(ArrayList::new));
		}
		
		if(kategorija != null) {
			kategorijaRestorana = Restoran.Kategorija.valueOf(kategorija.toUpperCase());
			Restoran.Kategorija kat = kategorijaRestorana;
			
			restaurants = restaurants.stream()
									 .filter((r)->r.getKategorija().equals(kat))
									 .collect(Collectors.toCollection(ArrayList::new));
			
		}
		
		return Response.ok(restaurants)
						.build();
	}
 
}
