package code.gen.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;

public enum DeliveryCriteria {


    AREABASED(1,"AreaBased","AreaBased"),
	RADIUSBASED(2,"RadiusBased","RadiusBased"),
	AREARADIUSBASED(3,"AreaRadiusBased","AreaRadiusBased");
	

    DeliveryCriteria( Integer id,String name,String description) {
this.id = id;
this.name = name;
this.description = description;
	}

    private static final Map<Integer , DeliveryCriteria> idToDeliveryCriteria  = new HashMap();
	static {
	for (DeliveryCriteria deliveryCriteria :  values())
idToDeliveryCriteria.put(deliveryCriteria.getId(), deliveryCriteria);

	}
	public static DeliveryCriteria fromId( Integer id) {
return idToDeliveryCriteria.get(id);
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
