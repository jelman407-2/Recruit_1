package recruit.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import recruit.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "recruits", path = "recruits")
public interface RecruitRepository
    extends PagingAndSortingRepository<Recruit, Long> {}
