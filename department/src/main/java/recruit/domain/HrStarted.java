package recruit.domain;

import java.util.*;
import lombok.*;
import recruit.domain.*;
import recruit.infra.AbstractEvent;

@Data
@ToString
public class HrStarted extends AbstractEvent {

    private Long id;
    private String email;
    private String jobId;
    private String name;
    private String empId;
    private String contents;
}
