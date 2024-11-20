package recruit.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import recruit.domain.*;

@Component
public class RecruitHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Recruit>> {

    @Override
    public EntityModel<Recruit> process(EntityModel<Recruit> model) {
        return model;
    }
}
