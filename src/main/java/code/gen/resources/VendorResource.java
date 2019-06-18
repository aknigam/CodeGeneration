

package code.gen.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import code.gen.entities.*;
import code.gen.service.VendorService;

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
@Path("/service/v1/vendors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendorResource {

    @Autowired
    private VendorService vendorService;

    public VendorResource() {
    }

    @POST
    public Response createVendor(
            @NotNull(message = "Vendor is required") @Valid Vendor vendor)
    {
        return Response.ok(vendorService.create(vendor)).build();
    }

    @PUT
    @Path("/{vendorId}")
    public Response updateVendor(@PathParam("vendorId") int vendorId,
            @NotNull(message = "Vendor is required for update") @Valid Vendor vendor){
        vendor.setId(vendorId);
        return Response.ok(vendorService.update(vendorId,  vendor)).build();
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




    // ONE TO ONE shopAddress STARTS -------------------------------------------------------
    @POST
    @Path("/{vendorId}/shopaddress")
    public Response addVendorShopAddress(@PathParam("vendorId") int vendorId,
        @NotNull(message = "Address is required for creation") @Valid  Address shopAddress)
    {
        vendorService.addVendorShopAddress(vendorId, shopAddress);
        int shopAddressId = shopAddress.getId();
        return Response.ok(shopAddressId).build();
    }

    @GET
    @Path("/{vendorId}/shopaddress")
    public Response getVendorShopAddress(@PathParam("vendorId") int vendorId){
    Address shopAddress = vendorService.getVendorShopAddress(vendorId);
    return Response.ok(shopAddress).build();
    }

    @PUT
    @Path("/{vendorId}/shopaddress")
    public Response updateVendorShopAddress(@PathParam("vendorId") int vendorId,
        @NotNull(message = "Address is required for update") @Valid  Address shopAddress)
    {
        vendorService.updateVendorShopAddress(vendorId, shopAddress);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{vendorId}/shopaddress")
    public Response deleteVendorShopAddress(@PathParam("vendorId") int vendorId){
    vendorService.deleteVendorShopAddress(vendorId);
    return Response.ok().build();
    }
    // ONE TO ONE shopAddress ENDS -------------------------------------------------------




}

