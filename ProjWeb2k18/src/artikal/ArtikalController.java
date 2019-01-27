package artikal;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restoran.Restoran;
import restoran.RestoranService;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Path("/Artikal")
public class ArtikalController {
	ArtikalService service = new ArtikalService();
	RestoranService restoranService = new RestoranService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artikal> getArticles() throws JsonParseException, JsonMappingException, IOException {
        return service.getArtikli();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getArticle(@PathParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return service.getArtikal(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object addArticle(Artikal article) throws JsonGenerationException, JsonMappingException, IOException {
        return service.createArtikal(article);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateArticle(Artikal article, @PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.updateArtikal(article);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object deleteArticle(@PathParam("id") String id) throws JsonGenerationException, JsonMappingException, IOException {
        return service.deleteArtikal(id);
    }
    
    @Path("/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchItems( @QueryParam("tip") String tip,
								 @QueryParam("cena") int cena,
								 @QueryParam("naziv") String naziv,
								 @QueryParam("restoran") String restoran) {
		Collection<Artikal> artikli = null;
		Artikal.Tip tipArtikla =  null;
		Restoran restorann = null;
		try {
			
		
			artikli = this.service.getArtikli();
		}catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		if(tip != null) {
			tipArtikla = Artikal.Tip.valueOf(tip.toUpperCase());
			final Artikal.Tip tipp = tipArtikla;
			artikli = artikli.stream()
						 .filter((item)->item.getTip().equals(tipp))
						 .collect(Collectors.toCollection(ArrayList::new));
		}
		
		if(cena > 0) {
			artikli = artikli.stream()
						 .filter((item)->item.getCena()==cena)
						 .collect(Collectors.toCollection(ArrayList::new));
		}
		
		if(naziv != null) { 
			artikli = artikli.stream()
						 .filter((item)->item.getNaziv().equals(naziv))
						 .collect(Collectors.toCollection(ArrayList::new));
		}
		
		if(restoran != null) {
			try {
				restorann = this.restoranService.getRestaurantByName(restoran);
			}catch(IOException e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
			String restaurantId = restorann.getId();
			artikli = artikli.stream()
						 .filter((item)->item.getRestoranId()==restaurantId)
						 .collect(Collectors.toCollection(ArrayList::new));
			
		}
		
		return Response.ok(artikli).build();
		
	}
}
