

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




}

