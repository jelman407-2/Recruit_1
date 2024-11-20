package recruit.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import recruit.DepartmentApplication;
import recruit.domain.Failed;
import recruit.domain.Passed;

@Entity
@Table(name = "Department_table")
@Data
//<<< DDD / Aggregate Root
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String empNo;

    private String name;

    private String deptId;

    private String deptName;

    private String passYn;

    @PostPersist
    public void onPostPersist() {
        Passed passed = new Passed(this);
        passed.publishAfterCommit();

        Failed failed = new Failed(this);
        failed.publishAfterCommit();
    }

    public static DepartmentRepository repository() {
        DepartmentRepository departmentRepository = DepartmentApplication.applicationContext.getBean(
            DepartmentRepository.class
        );
        return departmentRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notify(HrStarted hrStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Department department = new Department();
        repository().save(department);

        */

        /** Example 2:  finding and process
        
        repository().findById(hrStarted.get???()).ifPresent(department->{
            
            department // do something
            repository().save(department);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
