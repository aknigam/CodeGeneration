package code.gen;

import code.gen.entities.Person;
import code.gen.entities.Vendor;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;

import static org.assertj.core.api.Assertions.assertThat;


public class VendorResourceTest extends BaseResourseTest{


//    @Test
    public void testAccountCreationAndUserRegistration(){
        ResponseEntity<Vendor> vr = getVendor(9);
        Vendor vendor = vr.getBody();
        assertThat(vendor).isNotNull();

    }

    @Test
    public void testGetVendor(){
        Vendor vendor = getDummyVendor();
        Vendor v = createVendor(vendor);
        assertThat(v).isNotNull();
        v = getVendorById(9);
        assertThat(v).isNotNull();

    }

    private Vendor getDummyVendor() {
        Vendor v = new Vendor();
        Person p = new Person();
        p.setEmail("b@b.com");
        p.setFirstName("a");
        p.setLastName("a");
//        v.setOwner(p);
        v.setEmail("v@b.com");
        v.setCode("vc1");
        v.setName("vname");
        return v;
    }


}
