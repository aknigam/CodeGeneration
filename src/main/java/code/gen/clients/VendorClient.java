

package code.gen.clients;


import code.gen.entities.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;

public interface VendorClient {

    @POST("/service/v1/vendors")
    Call<Vendor> createVendor(@Body Vendor vendor);

    @PUT("/service/v1/vendors/{vendorId}")
    Call<Void> updateVendor(@Path("vendorId") int vendorId, @Body Vendor vendor);

    @GET("/service/v1/vendors/{vendorId}")
    Call<Vendor> getVendor(@Path("vendorId") int vendorId);

    @DELETE("/service/v1/vendors/{vendorId}")
    Call<Void> deleteVendor(@Path("vendorId") int vendorId);





    // ONE TO ONE shopAddress STARTS -------------------------------------------------------
    @POST("/service/v1/vendors/{vendorId}/shopaddress")
    Call<Address> addVendorShopAddress(@Path("vendorId") int vendorId, @Body Address shopAddress);

    @GET("/service/v1/vendors/{vendorId}/shopaddress")
    Call<Address> getVendorShopAddress(@Path("vendorId") int vendorId);

    @PUT("/service/v1/vendors/{vendorId}/shopaddress")
    Call<Void> updateVendorShopAddress(@Path("vendorId") int vendorId, @Body Address shopAddress);

    @DELETE("/service/v1/vendors/{vendorId}/shopaddress")
    Call<Void> deleteVendorShopAddress(@Path("vendorId") int vendorId);

    // ONE TO ONE shopAddress ENDS -------------------------------------------------------




        // MANY TO MANY paymentOptions STARTS -------------------------------------------------------

    // LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/paymentoptions/{paymentOptionId}/link")
    Call linkVendorPaymentOption(@Path("vendorId") int vendorId, @Path("paymentOptionId") int paymentOptionId);

    // UN-LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/paymentoptions/{paymentOptionId}/unlink")
    Call unLinkVendorPaymentOption(@Path("vendorId") int vendorId, @Path("paymentOptionId") int paymentOptionId);
    
        // MANY TO MANY paymentOptions STARTS -------------------------------------------------------




        // ONE TO MANY androidAppDetails STARTS --------------------------------------------------------

    // LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/androidappdetails/{androidAppDetailId}/link")
    Call linkVendorAndroidAppDetail(@Path("vendorId") int vendorId, @Path("androidAppDetailId") int androidAppDetailId);

    // UN-LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/androidappdetails/{androidAppDetailId}/unlink")
    Call unLinkVendorAndroidAppDetail(@Path("vendorId") int vendorId, @Path("androidAppDetailId") int androidAppDetailId);
    
    // CREATE OPERATION
    @POST("/service/v1/vendors/{vendorId}/androidappdetails")
    Call<AndroidAppDetail> addVendorAndroidAppDetail(@Path("vendorId") int vendorId, @Body AndroidAppDetail androidAppDetail);


    // UPDATE OPERATION
    @PUT("/service/v1/vendors/{vendorId}/androidappdetails/{androidAppDetailId}")
    Call<Void> updateVendorAndroidAppDetail(@Path("vendorId") int vendorId, AndroidAppDetail androidAppDetail);

    // GET OPERATION
    @GET("/service/v1/vendors/{vendorId}/androidappdetails/{androidAppDetailId}")
    Call<AndroidAppDetail> getVendorAndroidAppDetail(@Path("vendorId") int vendorId, @Path("androidAppDetailId") int androidAppDetailId);


    // SEARCH OPERATION
    @GET("/service/v1/vendors/{vendorId}/androidappdetails")
    Call<List<AndroidAppDetail>> searchVendorAndroidAppDetail(
            @Path("vendorId") int vendorId,
            @Query("page") int page,
            @Query("size") int noOfResults
    );
        // ONE TO MANY androidAppDetails STARTS --------------------------------------------------------





    // ONE TO ONE geoLocation STARTS -------------------------------------------------------
    @POST("/service/v1/vendors/{vendorId}/geolocation")
    Call<GeoLocation> addVendorGeoLocation(@Path("vendorId") int vendorId, @Body GeoLocation geoLocation);

    @GET("/service/v1/vendors/{vendorId}/geolocation")
    Call<GeoLocation> getVendorGeoLocation(@Path("vendorId") int vendorId);

    @PUT("/service/v1/vendors/{vendorId}/geolocation")
    Call<Void> updateVendorGeoLocation(@Path("vendorId") int vendorId, @Body GeoLocation geoLocation);

    @DELETE("/service/v1/vendors/{vendorId}/geolocation")
    Call<Void> deleteVendorGeoLocation(@Path("vendorId") int vendorId);

    // ONE TO ONE geoLocation ENDS -------------------------------------------------------




        // ONE TO MANY deliveryTimings STARTS --------------------------------------------------------

    // LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliverytimings/{deliveryTimingId}/link")
    Call linkVendorDeliveryTiming(@Path("vendorId") int vendorId, @Path("deliveryTimingId") int deliveryTimingId);

    // UN-LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliverytimings/{deliveryTimingId}/unlink")
    Call unLinkVendorDeliveryTiming(@Path("vendorId") int vendorId, @Path("deliveryTimingId") int deliveryTimingId);
    
    // CREATE OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliverytimings")
    Call<DeliveryTiming> addVendorDeliveryTiming(@Path("vendorId") int vendorId, @Body DeliveryTiming deliveryTiming);


    // UPDATE OPERATION
    @PUT("/service/v1/vendors/{vendorId}/deliverytimings/{deliveryTimingId}")
    Call<Void> updateVendorDeliveryTiming(@Path("vendorId") int vendorId, DeliveryTiming deliveryTiming);

    // GET OPERATION
    @GET("/service/v1/vendors/{vendorId}/deliverytimings/{deliveryTimingId}")
    Call<DeliveryTiming> getVendorDeliveryTiming(@Path("vendorId") int vendorId, @Path("deliveryTimingId") int deliveryTimingId);


    // SEARCH OPERATION
    @GET("/service/v1/vendors/{vendorId}/deliverytimings")
    Call<List<DeliveryTiming>> searchVendorDeliveryTiming(
            @Path("vendorId") int vendorId,
            @Query("page") int page,
            @Query("size") int noOfResults
    );
        // ONE TO MANY deliveryTimings STARTS --------------------------------------------------------





    // ONE TO ONE deliveryCriteria STARTS -------------------------------------------------------
    @POST("/service/v1/vendors/{vendorId}/deliverycriteria")
    Call<DeliveryCriteria> addVendorDeliveryCriteria(@Path("vendorId") int vendorId, @Body DeliveryCriteria deliveryCriteria);

    @GET("/service/v1/vendors/{vendorId}/deliverycriteria")
    Call<DeliveryCriteria> getVendorDeliveryCriteria(@Path("vendorId") int vendorId);

    @PUT("/service/v1/vendors/{vendorId}/deliverycriteria")
    Call<Void> updateVendorDeliveryCriteria(@Path("vendorId") int vendorId, @Body DeliveryCriteria deliveryCriteria);

    @DELETE("/service/v1/vendors/{vendorId}/deliverycriteria")
    Call<Void> deleteVendorDeliveryCriteria(@Path("vendorId") int vendorId);

    // ONE TO ONE deliveryCriteria ENDS -------------------------------------------------------



    // LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliveryareas/{deliveryAreaId}/link")
    Call linkVendorDeliveryArea(@Path("vendorId") int vendorId, @Path("deliveryAreaId") int deliveryAreaId);

    // UN-LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliveryareas/{deliveryAreaId}/unlink")
    Call unLinkVendorDeliveryArea(@Path("vendorId") int vendorId, @Path("deliveryAreaId") int deliveryAreaId);
    




    // ONE TO ONE taxDetails STARTS -------------------------------------------------------
    @POST("/service/v1/vendors/{vendorId}/taxdetails")
    Call<TaxDetails> addVendorTaxDetails(@Path("vendorId") int vendorId, @Body TaxDetails taxDetails);

    @GET("/service/v1/vendors/{vendorId}/taxdetails")
    Call<TaxDetails> getVendorTaxDetails(@Path("vendorId") int vendorId);

    @PUT("/service/v1/vendors/{vendorId}/taxdetails")
    Call<Void> updateVendorTaxDetails(@Path("vendorId") int vendorId, @Body TaxDetails taxDetails);

    @DELETE("/service/v1/vendors/{vendorId}/taxdetails")
    Call<Void> deleteVendorTaxDetails(@Path("vendorId") int vendorId);

    // ONE TO ONE taxDetails ENDS -------------------------------------------------------





    // ONE TO ONE vendorStatus STARTS -------------------------------------------------------
    @POST("/service/v1/vendors/{vendorId}/vendorstatus")
    Call<VendorStatus> addVendorVendorStatus(@Path("vendorId") int vendorId, @Body VendorStatus vendorStatus);

    @GET("/service/v1/vendors/{vendorId}/vendorstatus")
    Call<VendorStatus> getVendorVendorStatus(@Path("vendorId") int vendorId);

    @PUT("/service/v1/vendors/{vendorId}/vendorstatus")
    Call<Void> updateVendorVendorStatus(@Path("vendorId") int vendorId, @Body VendorStatus vendorStatus);

    @DELETE("/service/v1/vendors/{vendorId}/vendorstatus")
    Call<Void> deleteVendorVendorStatus(@Path("vendorId") int vendorId);

    // ONE TO ONE vendorStatus ENDS -------------------------------------------------------



    // LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliveryagents/{deliveryAgentId}/link")
    Call linkVendorDeliveryAgent(@Path("vendorId") int vendorId, @Path("deliveryAgentId") int deliveryAgentId);

    // UN-LINK OPERATION
    @POST("/service/v1/vendors/{vendorId}/deliveryagents/{deliveryAgentId}/unlink")
    Call unLinkVendorDeliveryAgent(@Path("vendorId") int vendorId, @Path("deliveryAgentId") int deliveryAgentId);
    



}

