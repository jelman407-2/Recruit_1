package recruit.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import recruit.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "departments",
    path = "departments"
)
public interface DepartmentRepository
    extends PagingAndSortingRepository<Department, Long> {}
