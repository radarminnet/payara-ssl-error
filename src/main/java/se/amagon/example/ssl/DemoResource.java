package se.amagon.example.ssl;

import jakarta.ws.rs.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("demo")
public class DemoResource {

    @GET
    @Path("error")
    @Produces(MediaType.TEXT_PLAIN)
    public Response error() {
        try {
            final var client = ClientBuilder.newClient();

            client.target("https://www.vikinglineartist.com/")
                  .path("/")
                  .request()
                  .get();

            client.close();

            return Response.ok()
                           .entity("OK")
                           .build();
        } catch (WebApplicationException | ProcessingException e) {
            return Response.serverError()
                           .entity(e.getMessage())
                           .build();
        }
    }

    @GET
    @Path("ok")
    @Produces(MediaType.TEXT_PLAIN)
    public Response ok() {
        try {
            final var client = ClientBuilder.newClient();

            client.target("https://www.google.com/")
                  .path("/")
                  .request()
                  .get();

            client.close();

            return Response.ok()
                           .entity("OK")
                           .build();
        } catch (WebApplicationException | ProcessingException e) {
            return Response.serverError()
                           .entity(e.getMessage())
                           .build();
        }
    }

}
