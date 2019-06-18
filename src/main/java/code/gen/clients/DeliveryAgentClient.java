

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

public interface DeliveryAgentClient {

    @POST("/service/v1/deliveryAgents")
    Call<DeliveryAgent> createDeliveryAgent(@Body DeliveryAgent deliveryAgent);

    @PUT("/service/v1/deliveryAgents/{deliveryAgentId}")
    Call<Void> updateDeliveryAgent(@Path("deliveryAgentId") int deliveryAgentId, @Body DeliveryAgent deliveryAgent);

    @GET("/service/v1/deliveryAgents/{deliveryAgentId}")
    Call<DeliveryAgent> getDeliveryAgent(@Path("deliveryAgentId") int deliveryAgentId);

    @DELETE("/service/v1/deliveryAgents/{deliveryAgentId}")
    Call<Void> deleteDeliveryAgent(@Path("deliveryAgentId") int deliveryAgentId);




}

