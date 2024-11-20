package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class HrStarted extends AbstractEvent {

    private Long id;
    private String email;
    private String jobId;
    private String name;
    private String empId;
    private String contents;

    public HrStarted(Hr aggregate) {
        super(aggregate);
    }

    public HrStarted() {
        super();
    }
}
//>>> DDD / Domain Event
