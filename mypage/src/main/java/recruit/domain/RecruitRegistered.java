package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import recruit.infra.AbstractEvent;

@Data
public class RecruitRegistered extends AbstractEvent {

    private Long id;
    private String email;
    private String name;
    private String jobId;
    private Date regDate;
    private String contents;
}
