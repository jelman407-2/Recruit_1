package recruit.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import recruit.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "hrs", path = "hrs")
public interface HrRepository extends PagingAndSortingRepository<Hr, Long> {}
