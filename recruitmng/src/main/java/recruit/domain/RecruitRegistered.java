package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RecruitRegistered extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private String jobId;
    private Date regDate;
    private String contents;

    public RecruitRegistered(Recruit aggregate) {
        super(aggregate);
    }

    public RecruitRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
