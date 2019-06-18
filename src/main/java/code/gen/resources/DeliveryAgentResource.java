

package code.gen.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import code.gen.entities.*;
import code.gen.service.DeliveryAgentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// NOT needed in case of Jersey
@Component
@Path("/service/v1/deliveryAgents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryAgentResource {

    @Autowired
    private DeliveryAgentService deliveryAgentService;

    public DeliveryAgentResource() {
    }

    @POST
    public Response createDeliveryAgent(
            @NotNull(message = "DeliveryAgent is required") @Valid DeliveryAgent deliveryAgent)
    {
        return Response.ok(deliveryAgentService.create(deliveryAgent)).build();
    }

    @PUT
    @Path("/{deliveryAgentId}")
    public Response updateDeliveryAgent(@PathParam("deliveryAgentId") int deliveryAgentId,
            @NotNull(message = "DeliveryAgent is required for update") @Valid DeliveryAgent deliveryAgent){
        deliveryAgent.setId(deliveryAgentId);
        return Response.ok(deliveryAgentService.update(deliveryAgentId,  deliveryAgent)).build();
    }

    @GET
    @Path("/{deliveryAgentId}")
    public Response getDeliveryAgent(@PathParam("deliveryAgentId") int deliveryAgentId){
        return Response.ok(deliveryAgentService.get(deliveryAgentId)).build();
    }

    @DELETE
    @Path("/{deliveryAgentId}")
    public Response deleteDeliveryAgent(@PathParam("deliveryAgentId") int deliveryAgentId){
        deliveryAgentService.delete(deliveryAgentId);
        return Response.ok().build();
    }



}

