package code.gen;

import code.gen.entities.Vendor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface VendorApi {

    @GET("service/v1/vendors/{vendorId}")
    Call<Vendor> getVendor(@Path("vendorId") int vendorId);

    @POST("service/v1/vendors")
    Call<Void> createVendor(@Body Vendor vendor);
}
