package server;

import model.Directory;
import model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import java.util.List;

@Path("/service")
public class Service {
    private final static Handler handler = new Handler();

    @GET
    @Path("/getItems")
    @Produces(MediaType.APPLICATION_XML)
    public Directory getItems() throws JAXBException {
        return new Directory(handler.getItems());
    }

    @POST
    @Path("/addItem")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response addItem(Item item) throws JAXBException {
        handler.addItem(item);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("deleteItem/{itemName}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response deleteItem(@PathParam("itemName") String name) throws JAXBException {
        handler.deleteItem(name);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/updateItem")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response updateItem(Item item) throws JAXBException {
        handler.updateItem(item);
        return Response.status(Response.Status.OK).build();
    }
}
