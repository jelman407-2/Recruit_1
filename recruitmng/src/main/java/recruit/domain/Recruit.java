package recruit.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import recruit.RecruitmngApplication;
import recruit.domain.RecruitRegistered;

@Entity
@Table(name = "Recruit_table")
@Data
//<<< DDD / Aggregate Root
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String jobId;

    private Date regDate;

    private String contents;

    @PostPersist
    public void onPostPersist() {
        RecruitRegistered recruitRegistered = new RecruitRegistered(this);
        recruitRegistered.publishAfterCommit();
    }

    public static RecruitRepository repository() {
        RecruitRepository recruitRepository = RecruitmngApplication.applicationContext.getBean(
            RecruitRepository.class
        );
        return recruitRepository;
    }
}
//>>> DDD / Aggregate Root
