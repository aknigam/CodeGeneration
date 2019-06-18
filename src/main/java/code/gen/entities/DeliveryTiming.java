package code.gen.entities;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeliveryTiming {

    public DeliveryTiming() {}

    private Integer id;

    @NotNull(message = "DeliveryTiming - startTime cannot be null ")
    private Date startTime;

    @NotNull(message = "DeliveryTiming - endTime cannot be null ")
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
