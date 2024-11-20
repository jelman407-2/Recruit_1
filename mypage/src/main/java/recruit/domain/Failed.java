package recruit.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import recruit.infra.AbstractEvent;

@Data
public class Failed extends AbstractEvent {

    private Long id;
    private String empNo;
    private String name;
    private String deptId;
    private String deptName;
    private String passYn;
}
