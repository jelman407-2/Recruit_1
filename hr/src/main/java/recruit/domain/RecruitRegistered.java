package recruit.domain;

import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

@Data
@ToString
public class RecruitRegistered extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private String jobId;
    private Date regDate;
    private String contents;
}
