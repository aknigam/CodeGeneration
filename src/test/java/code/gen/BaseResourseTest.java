package code.gen;


import code.gen.clients.VendorClient;
import code.gen.entities.Vendor;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/*
Refer: https://spring.io/guides/gs/testing-web/
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EdukanWebConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class BaseResourseTest {

    @LocalServerPort
    protected int port;

//    @Autowired
//    protected TestRestTemplate restTemplate;


    private final RestTemplate restTemplate = new RestTemplate();

    protected String bearer;

    private Retrofit retrofit;
    private VendorClient vendorApi;


    @Before
    public void  init(){

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        retrofit = getRetrofitBuilder();
        vendorApi =  retrofit.create(VendorClient.class);

    }

    private Retrofit getRetrofitBuilder() {

        GsonConverterFactory gson =  GsonConverterFactory.create(new GsonBuilder().setDateFormat
                ("yyyy-MM-dd'T'HH:mm:ss")
                .create());
        return new Retrofit.Builder()
                .baseUrl("http://localhost:" + port +"/")
                .callFactory(getBuilder().build())
//                        .addInterceptor(networkCheckInterceptor(context))
//                        .addInterceptor(authHeaderIntercepter(context)).build())
                .addConverterFactory(gson)
                .build();
    }
    private static final int CONNECT_TIMEOUT_MILLISECONDS = 5 * 1000; // 5s
    private static final int READ_TIMEOUT_MILLISECONDS = 5 * 1000; // 5s

    @NonNull
    private OkHttpClient.Builder getBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS);
        return builder;
    }


    protected HttpHeaders getAuthHttpHeaders() {
        return getAuthHttpHeaders("bearer " + bearer);
    }

    protected HttpHeaders getAuthHttpHeaders(String s) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", s);
        return headers;
    }

    @Deprecated
    protected ResponseEntity<Vendor> getVendor(int vendorId) {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        return this.restTemplate.exchange("http://localhost:" + port + "/service/v1/vendors/"+ vendorId,
                HttpMethod.GET,
                requestEntity,
                Vendor.class);
    }


    protected Vendor getVendorById(int vendorId) {
        VendorApi api =  retrofit.create(VendorApi.class);
        Call<Vendor> resp = api.getVendor(vendorId);
        try {
            Response<Vendor> vendor = resp.execute();
            return vendor.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected Vendor createVendor(Vendor vendor) {
        Call<Vendor> call = vendorApi.createVendor(vendor);
        try {
            Response<Vendor> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }



    // API end points

    /*
    protected ResponseEntity<Question> submitQuestion(HttpEntity<Object> entity) {
        return this.restTemplate.exchange("http://localhost:" + port + "/api/questions",
                HttpMethod.POST,
                entity,
                Question.class);
    }

    protected Account createAccount(Account account) {
        HttpEntity<Object> entity = new HttpEntity<>(account, getAuthHttpHeaders());
        ResponseEntity<Account> response = this.restTemplate.exchange("http://localhost:" + port + "/api/account",
                HttpMethod.POST,
                entity,
                Account.class);
        return  response.getBody();
    }


    protected AppUser addUser(AppUser accountAdmin) {
        HttpEntity<Object> entity = new HttpEntity<>(accountAdmin, getAuthHttpHeaders());
        ResponseEntity<AppUser> response = this.restTemplate.exchange("http://localhost:" + port + "/api/users",
                HttpMethod.POST,
                entity,
                AppUser.class);
        return  response.getBody();
    }

    */


}
