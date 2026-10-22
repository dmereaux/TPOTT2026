package org.example.api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/montant")
public class CalculRestApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMontant(@QueryParam("total") double total) {
        CalculFrais montantService = new CalculFrais();
        try {
            double result = montantService.montant(total);
            return Response.ok("{\"montant\": " + result + "}").build();
        } catch (MonException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
