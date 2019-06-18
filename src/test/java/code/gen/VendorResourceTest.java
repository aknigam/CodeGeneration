package code.gen;

import code.gen.clients.VendorClient;
import code.gen.entities.Person;
import code.gen.entities.Vendor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.framework.ServerResponse;
import test.framework.TestCase;
import test.framework.TestScenario;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class VendorResourceTest extends BaseResourseTest {


    private static Logger LOG = LoggerFactory.getLogger(VendorResourceTest.class);

    private VendorClient vendorClient;

    @Before
    public void  init(){
        super.init();
        vendorClient =  getRetrofitBuilder().create(VendorClient.class);

    }

    @Test
    public void testCreateVendor(){

        List<TestCase<Vendor>> scenarios =  readTestData("vendor");
        for(TestCase<Vendor> s : scenarios) {

            LOG.info("Executing test case\n"+s);

            Vendor vendor = s.getData();

            ServerResponse<Vendor> resp = getResult(vendorClient.createVendor(vendor));
            if(s.isExpectedSuccess()) {
                assertThat(resp.isSuccessful()).isTrue();
                assertThat(resp.getEntity()).isNotNull();
                assertThat(resp.getEntity().getId()).isNotNull();
                compareObjects(vendor, resp.getEntity());
            }
            else {
                assertThat(resp.isSuccessful()).isFalse();
                assertThat(resp.getEntity()).isNull();
            }

        }


    }

    private void compareObjects(Vendor vendor, Vendor entity) {

    }

    private List<TestCase<Vendor>> readTestData(String name) {
        ObjectMapper om = new ObjectMapper();

        try {
            String fileName = "/Users/a.nigam/Documents/workspace/restful-service-code-generator/src/main" +
                    "/resources/generated/testdata/"+name+".json" ;
            List<TestCase<Vendor>> l = om.readValue(new File(fileName), new TypeReference<List<TestCase<Vendor>>>() {});

            return l;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }




}
