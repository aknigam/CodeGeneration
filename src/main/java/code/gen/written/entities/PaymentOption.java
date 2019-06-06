package code.gen.written.entities;

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;

public enum PaymentOption {


    PAYTM(1,"paytm","paytm"),
	UPI(2,"upi","upi"),
	CASH(3,"cash","cash");
	

    PaymentOption( Integer id,String name,String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

    private static final Map<Integer , PaymentOption> idToPaymentOption  = new HashMap();
	static {
	for (PaymentOption paymentOption :  values())
		idToPaymentOption.put(paymentOption.getId(), paymentOption);

	}
	public static PaymentOption fromId( Integer id) {
		return idToPaymentOption.get(id);
	}



    private Integer id;

    private String name;

    private String description;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
