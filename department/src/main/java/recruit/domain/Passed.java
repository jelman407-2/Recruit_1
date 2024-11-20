package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Passed extends AbstractEvent {

    private Long id;
    private String empNo;
    private String name;
    private String deptId;
    private String deptName;
    private String passYn;

    public Passed(Department aggregate) {
        super(aggregate);
    }

    public Passed() {
        super();
    }
}
//>>> DDD / Domain Event
