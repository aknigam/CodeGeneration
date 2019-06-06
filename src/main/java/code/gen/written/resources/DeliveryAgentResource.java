

package code.gen.written.resources;


import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import code.gen.entities.*;
import code.gen.written.service.DeliveryAgentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Component
@Path("/service/v1/deliveryAgents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryAgentResource {

//    @Autowired
    private DeliveryAgentService deliveryAgentService;

    public DeliveryAgentResource() {
    }

    @POST
    public Response createDeliveryAgent(DeliveryAgent deliveryAgent){
        return Response.ok(deliveryAgentService.create(deliveryAgent)).build();
    }

    @PUT
    @Path("/{deliveryAgentId}")
    public Response updateDeliveryAgent(@PathParam("deliveryAgentId") int deliveryAgentId, DeliveryAgent deliveryAgent){
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




    // ONE TO ONE person STARTS -------------------------------------------------------
    @POST
    @Path("/{deliveryAgentId}/person")
    public Response addDeliveryAgentPerson(@PathParam("deliveryAgentId") int deliveryAgentId, Person person){
    int personId = deliveryAgentService.addDeliveryAgentPerson(deliveryAgentId, person);
    return Response.ok(personId).build();
    }

    @GET
    @Path("/{deliveryAgentId}/person")
    public Response getDeliveryAgentPerson(@PathParam("deliveryAgentId") int deliveryAgentId){
    Person person = deliveryAgentService.getDeliveryAgentPerson(deliveryAgentId);
    return Response.ok(person).build();
    }

    @PUT
    @Path("/{deliveryAgentId}/person")
    public Response updateDeliveryAgentPerson(@PathParam("deliveryAgentId") int deliveryAgentId, Person person){
    deliveryAgentService.updateDeliveryAgentPerson(deliveryAgentId, person);
    return Response.ok().build();
    }

    @DELETE
    @Path("/{deliveryAgentId}/person")
    public Response deleteDeliveryAgentPerson(@PathParam("deliveryAgentId") int deliveryAgentId){
    deliveryAgentService.deleteDeliveryAgentPerson(deliveryAgentId);
    return Response.ok().build();
    }
    // ONE TO ONE person ENDS -------------------------------------------------------




}

