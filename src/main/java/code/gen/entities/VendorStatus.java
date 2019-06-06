package code.gen.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;

public enum VendorStatus {


    ACTIVE(1,"Active"),
	INACTIVE(2,"Inactive"),
	VERIFIED(3,"Verified");
	

    VendorStatus( Integer id,String statusName) {
this.id = id;
this.statusName = statusName;
	}

    private static final Map<Integer , VendorStatus> idToVendorStatus  = new HashMap();
	static {
	for (VendorStatus vendorStatus :  values())
idToVendorStatus.put(vendorStatus.getId(), vendorStatus);

	}
	public static VendorStatus fromId( Integer id) {
return idToVendorStatus.get(id);
	}



    private Integer id;

    private String statusName;


    public Integer getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

}
