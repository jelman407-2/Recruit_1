package recruit.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import recruit.HrApplication;
import recruit.domain.HrStarted;

@Entity
@Table(name = "Hr_table")
@Data
//<<< DDD / Aggregate Root
public class Hr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String jobId;

    private String name;

    private String empId;

    private String contents;

    @PostPersist
    public void onPostPersist() {
        HrStarted hrStarted = new HrStarted(this);
        hrStarted.publishAfterCommit();
    }

    public static HrRepository repository() {
        HrRepository hrRepository = HrApplication.applicationContext.getBean(
            HrRepository.class
        );
        return hrRepository;
    }

    //<<< Clean Arch / Port Method
    public static void hrStart(RecruitRegistered recruitRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Hr hr = new Hr();
        repository().save(hr);

        */

        /** Example 2:  finding and process
        
        repository().findById(recruitRegistered.get???()).ifPresent(hr->{
            
            hr // do something
            repository().save(hr);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
