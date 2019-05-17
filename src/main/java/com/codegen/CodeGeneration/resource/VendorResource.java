package com.codegen.CodeGeneration.resource;


import com.codegen.CodeGeneration.entity.Vendor;
import com.codegen.CodeGeneration.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
@Path("/api/vendors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendorResource {

    @Autowired
    private VendorService vendorService;

    public VendorResource() {
    }

    @POST
    public Response createVendor(Vendor vendor){
        return Response.ok(vendorService.create(vendor)).build();
    }

    @PUT
    @Path("/{vendorId}")
    public Response updateVendor(@PathParam("vendorId") int vendorId, Vendor vendor){
        vendor.setId(vendorId);
        return Response.ok(vendorService.update(vendorId, vendor)).build();
    }

    @GET
    @Path("/{vendorId}")
    public Response getVendor(@PathParam("vendorId") int vendorId){
        return Response.ok(vendorService.get(vendorId)).build();
    }

    @DELETE
    @Path("/{vendorId}")
    public Response deleteVendor(@PathParam("vendorId") int vendorId){
        vendorService.delete(vendorId);
        return Response.ok().build();
    }
}
