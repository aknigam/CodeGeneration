

package code.gen.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import code.gen.entities.*;
import code.gen.service.VendorService;

import javax.validation.Valid;
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
    public Response createVendor(@Valid Vendor vendor){
        return Response.ok(vendorService.create(vendor)).build();
    }

    @PUT
    @Path("/{vendorId}")
    public Response updateVendor(@PathParam("vendorId") int vendorId, Vendor vendor){
        vendor.setId(vendorId);
        return Response.ok(vendorService.update(vendorId,  vendor)).build();
    }

    @GET
    @Path("/{vendorId}")
    public Response getVendor(@PathParam("vendorId") int vendorId){
        System.out.println("getting vendor !!!");
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
    public Response addVendorShopAddress(@PathParam("vendorId") int vendorId, Address shopAddress){
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
    public Response updateVendorShopAddress(@PathParam("vendorId") int vendorId, Address shopAddress){
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




        // MANY TO MANY paymentOptions STARTS -------------------------------------------------------

    // LINK OPERATION
    @POST
    @Path("/{vendorId}/paymentoptions/{paymentOptionId}/link")
    public Response linkVendorPaymentOption(@PathParam("vendorId") int vendorId, @PathParam("paymentOptionId") int
    paymentOptionId){

    vendorService.linkVendorPaymentOption(vendorId, paymentOptionId);
    return Response.ok().build();
    }

    // UN-LINK OPERATION
    @POST
    @Path("/{vendorId}/paymentoptions/{paymentOptionId}/unlink")
    public Response unLinkVendorPaymentOption(@PathParam("vendorId") int vendorId, @PathParam("paymentOptionId") int
    paymentOptionId){

    vendorService.unLinkVendorPaymentOption(vendorId, paymentOptionId);
    return Response.ok().build();

    }
        // MANY TO MANY paymentOptions STARTS -------------------------------------------------------




        // ONE TO MANY androidAppDetails STARTS --------------------------------------------------------

    // LINK OPERATION
    @POST
    @Path("/{vendorId}/androidappdetails/{androidAppDetailId}/link")
    public Response linkVendorAndroidAppDetail(@PathParam("vendorId") int vendorId, @PathParam("androidAppDetailId") int
    androidAppDetailId){

    vendorService.linkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    return Response.ok().build();
    }

    // UN-LINK OPERATION
    @POST
    @Path("/{vendorId}/androidappdetails/{androidAppDetailId}/unlink")
    public Response unLinkVendorAndroidAppDetail(@PathParam("vendorId") int vendorId, @PathParam("androidAppDetailId") int
    androidAppDetailId){

    vendorService.unLinkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    return Response.ok().build();

    }
    // CREATE OPERATION
    @POST
    @Path("/{vendorId}/androidappdetails")
    public Response addVendorAndroidAppDetail(@PathParam("vendorId") int vendorId, AndroidAppDetail androidAppDetail){
    // check for duplicate
    vendorService.addVendorAndroidAppDetail(vendorId, androidAppDetail);
    return Response.ok(androidAppDetail).build();
    }

    // UPDATE OPERATION
    @PUT
    @Path("/{vendorId}/androidappdetails/{androidAppDetailId}")
    public Response updateVendorAndroidAppDetail(@PathParam("vendorId") int vendorId, AndroidAppDetail androidAppDetail){

    vendorService.updateVendorAndroidAppDetail(vendorId, androidAppDetail);
    return Response.ok().build();
    }

    // GET OPERATION
    @GET
    @Path("/{vendorId}/androidappdetails/{androidAppDetailId}")
    public Response getVendorAndroidAppDetail(@PathParam("vendorId") int vendorId, @PathParam("androidAppDetailId") int
    androidAppDetailId){
    // check for duplicate
    AndroidAppDetail androidAppDetail = vendorService.getVendorAndroidAppDetail(vendorId, androidAppDetailId);
    return Response.ok(androidAppDetail).build();
    }


    // SEARCH OPERATION
    @GET
    @Path("/{vendorId}/androidappdetails")
    public Response searchVendorAndroidAppDetail(
        @PathParam("vendorId") int vendorId,
        @QueryParam("page") int page,
        @QueryParam("size") int noOfResults
    ){
    // check for duplicate
        List<AndroidAppDetail> androidAppDetails = vendorService.searchVendorAndroidAppDetails(vendorId, "", page, noOfResults);
        return Response.ok(androidAppDetails).build();
    }
        // ONE TO MANY androidAppDetails STARTS --------------------------------------------------------





    // ONE TO ONE geoLocation STARTS -------------------------------------------------------
    @POST
    @Path("/{vendorId}/geolocation")
    public Response addVendorGeoLocation(@PathParam("vendorId") int vendorId, GeoLocation geoLocation){
        vendorService.addVendorGeoLocation(vendorId, geoLocation);
        int geoLocationId = geoLocation.getId();
        return Response.ok(geoLocationId).build();
    }

    @GET
    @Path("/{vendorId}/geolocation")
    public Response getVendorGeoLocation(@PathParam("vendorId") int vendorId){
    GeoLocation geoLocation = vendorService.getVendorGeoLocation(vendorId);
    return Response.ok(geoLocation).build();
    }

    @PUT
    @Path("/{vendorId}/geolocation")
    public Response updateVendorGeoLocation(@PathParam("vendorId") int vendorId, GeoLocation geoLocation){
    vendorService.updateVendorGeoLocation(vendorId, geoLocation);
    return Response.ok().build();
    }

    @DELETE
    @Path("/{vendorId}/geolocation")
    public Response deleteVendorGeoLocation(@PathParam("vendorId") int vendorId){
    vendorService.deleteVendorGeoLocation(vendorId);
    return Response.ok().build();
    }
    // ONE TO ONE geoLocation ENDS -------------------------------------------------------




        // ONE TO MANY deliveryTimings STARTS --------------------------------------------------------

    // LINK OPERATION
    @POST
    @Path("/{vendorId}/deliverytimings/{deliveryTimingId}/link")
    public Response linkVendorDeliveryTiming(@PathParam("vendorId") int vendorId, @PathParam("deliveryTimingId") int
    deliveryTimingId){

    vendorService.linkVendorDeliveryTiming(vendorId, deliveryTimingId);
    return Response.ok().build();
    }

    // UN-LINK OPERATION
    @POST
    @Path("/{vendorId}/deliverytimings/{deliveryTimingId}/unlink")
    public Response unLinkVendorDeliveryTiming(@PathParam("vendorId") int vendorId, @PathParam("deliveryTimingId") int
    deliveryTimingId){

    vendorService.unLinkVendorDeliveryTiming(vendorId, deliveryTimingId);
    return Response.ok().build();

    }
    // CREATE OPERATION
    @POST
    @Path("/{vendorId}/deliverytimings")
    public Response addVendorDeliveryTiming(@PathParam("vendorId") int vendorId, DeliveryTiming deliveryTiming){
    // check for duplicate
    vendorService.addVendorDeliveryTiming(vendorId, deliveryTiming);
    return Response.ok(deliveryTiming).build();
    }

    // UPDATE OPERATION
    @PUT
    @Path("/{vendorId}/deliverytimings/{deliveryTimingId}")
    public Response updateVendorDeliveryTiming(@PathParam("vendorId") int vendorId, DeliveryTiming deliveryTiming){

    vendorService.updateVendorDeliveryTiming(vendorId, deliveryTiming);
    return Response.ok().build();
    }

    // GET OPERATION
    @GET
    @Path("/{vendorId}/deliverytimings/{deliveryTimingId}")
    public Response getVendorDeliveryTiming(@PathParam("vendorId") int vendorId, @PathParam("deliveryTimingId") int
    deliveryTimingId){
    // check for duplicate
    DeliveryTiming deliveryTiming = vendorService.getVendorDeliveryTiming(vendorId, deliveryTimingId);
    return Response.ok(deliveryTiming).build();
    }


    // SEARCH OPERATION
    @GET
    @Path("/{vendorId}/deliverytimings")
    public Response searchVendorDeliveryTiming(
        @PathParam("vendorId") int vendorId,
        @QueryParam("page") int page,
        @QueryParam("size") int noOfResults
    ){
    // check for duplicate
        List<DeliveryTiming> deliveryTimings = vendorService.searchVendorDeliveryTimings(vendorId, "", page, noOfResults);
        return Response.ok(deliveryTimings).build();
    }
        // ONE TO MANY deliveryTimings STARTS --------------------------------------------------------





    // ONE TO ONE deliveryCriteria STARTS -------------------------------------------------------
    @POST
    @Path("/{vendorId}/deliverycriteria")
    public Response addVendorDeliveryCriteria(@PathParam("vendorId") int vendorId, DeliveryCriteria deliveryCriteria){
        vendorService.addVendorDeliveryCriteria(vendorId, deliveryCriteria);
        int deliveryCriteriaId = deliveryCriteria.getId();
        return Response.ok(deliveryCriteriaId).build();
    }

    @GET
    @Path("/{vendorId}/deliverycriteria")
    public Response getVendorDeliveryCriteria(@PathParam("vendorId") int vendorId){
    DeliveryCriteria deliveryCriteria = vendorService.getVendorDeliveryCriteria(vendorId);
    return Response.ok(deliveryCriteria).build();
    }

    @PUT
    @Path("/{vendorId}/deliverycriteria")
    public Response updateVendorDeliveryCriteria(@PathParam("vendorId") int vendorId, DeliveryCriteria deliveryCriteria){
    vendorService.updateVendorDeliveryCriteria(vendorId, deliveryCriteria);
    return Response.ok().build();
    }

    @DELETE
    @Path("/{vendorId}/deliverycriteria")
    public Response deleteVendorDeliveryCriteria(@PathParam("vendorId") int vendorId){
    vendorService.deleteVendorDeliveryCriteria(vendorId);
    return Response.ok().build();
    }
    // ONE TO ONE deliveryCriteria ENDS -------------------------------------------------------



    // LINK OPERATION
    @POST
    @Path("/{vendorId}/deliveryareas/{deliveryAreaId}/link")
    public Response linkVendorDeliveryArea(@PathParam("vendorId") int vendorId, @PathParam("deliveryAreaId") int
    deliveryAreaId){

    vendorService.linkVendorDeliveryArea(vendorId, deliveryAreaId);
    return Response.ok().build();
    }

    // UN-LINK OPERATION
    @POST
    @Path("/{vendorId}/deliveryareas/{deliveryAreaId}/unlink")
    public Response unLinkVendorDeliveryArea(@PathParam("vendorId") int vendorId, @PathParam("deliveryAreaId") int
    deliveryAreaId){

    vendorService.unLinkVendorDeliveryArea(vendorId, deliveryAreaId);
    return Response.ok().build();

    }




    // ONE TO ONE taxDetails STARTS -------------------------------------------------------
    @POST
    @Path("/{vendorId}/taxdetails")
    public Response addVendorTaxDetails(@PathParam("vendorId") int vendorId, TaxDetails taxDetails){
        vendorService.addVendorTaxDetails(vendorId, taxDetails);
        int taxDetailsId = taxDetails.getId();
        return Response.ok(taxDetailsId).build();
    }

    @GET
    @Path("/{vendorId}/taxdetails")
    public Response getVendorTaxDetails(@PathParam("vendorId") int vendorId){
    TaxDetails taxDetails = vendorService.getVendorTaxDetails(vendorId);
    return Response.ok(taxDetails).build();
    }

    @PUT
    @Path("/{vendorId}/taxdetails")
    public Response updateVendorTaxDetails(@PathParam("vendorId") int vendorId, TaxDetails taxDetails){
    vendorService.updateVendorTaxDetails(vendorId, taxDetails);
    return Response.ok().build();
    }

    @DELETE
    @Path("/{vendorId}/taxdetails")
    public Response deleteVendorTaxDetails(@PathParam("vendorId") int vendorId){
    vendorService.deleteVendorTaxDetails(vendorId);
    return Response.ok().build();
    }
    // ONE TO ONE taxDetails ENDS -------------------------------------------------------





    // ONE TO ONE vendorStatus STARTS -------------------------------------------------------
    @POST
    @Path("/{vendorId}/vendorstatus")
    public Response addVendorVendorStatus(@PathParam("vendorId") int vendorId, VendorStatus vendorStatus){
        vendorService.addVendorVendorStatus(vendorId, vendorStatus);
        int vendorStatusId = vendorStatus.getId();
        return Response.ok(vendorStatusId).build();
    }

    @GET
    @Path("/{vendorId}/vendorstatus")
    public Response getVendorVendorStatus(@PathParam("vendorId") int vendorId){
    VendorStatus vendorStatus = vendorService.getVendorVendorStatus(vendorId);
    return Response.ok(vendorStatus).build();
    }

    @PUT
    @Path("/{vendorId}/vendorstatus")
    public Response updateVendorVendorStatus(@PathParam("vendorId") int vendorId, VendorStatus vendorStatus){
    vendorService.updateVendorVendorStatus(vendorId, vendorStatus);
    return Response.ok().build();
    }

    @DELETE
    @Path("/{vendorId}/vendorstatus")
    public Response deleteVendorVendorStatus(@PathParam("vendorId") int vendorId){
    vendorService.deleteVendorVendorStatus(vendorId);
    return Response.ok().build();
    }
    // ONE TO ONE vendorStatus ENDS -------------------------------------------------------



    // LINK OPERATION
    @POST
    @Path("/{vendorId}/deliveryagents/{deliveryAgentId}/link")
    public Response linkVendorDeliveryAgent(@PathParam("vendorId") int vendorId, @PathParam("deliveryAgentId") int
    deliveryAgentId){

    vendorService.linkVendorDeliveryAgent(vendorId, deliveryAgentId);
    return Response.ok().build();
    }

    // UN-LINK OPERATION
    @POST
    @Path("/{vendorId}/deliveryagents/{deliveryAgentId}/unlink")
    public Response unLinkVendorDeliveryAgent(@PathParam("vendorId") int vendorId, @PathParam("deliveryAgentId") int
    deliveryAgentId){

    vendorService.unLinkVendorDeliveryAgent(vendorId, deliveryAgentId);
    return Response.ok().build();

    }



}

