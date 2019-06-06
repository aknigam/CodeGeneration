package code.gen.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.util.Date;
import java.util.Date;

public class DeliveryTiming {

    public DeliveryTiming() {}

    private Integer id;

    private Date startTime;

    private Date endTime;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
