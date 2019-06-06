package code.gen;

import code.gen.entities.Person;
import code.gen.entities.Vendor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationTest {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Vendor vendor = getDummyVendor();
        Set<ConstraintViolation<Vendor>> violations = validator.validate(vendor);

        for(ConstraintViolation cv : violations ) {
//            System.out.println(cv.getClass().getName());
            System.out.println(cv.getMessage());
        }

    }

    private static Vendor getDummyVendor() {
        Vendor v = new Vendor();
        Person p = new Person();
        p.setEmail("b@b.com");
        p.setFirstName("a");
        p.setLastName("a");
        v.setOwner(p);
        v.setEmail("v@b.com");
        v.setCode("vc1");
        v.setName("vname");
        return v;
    }
}
