package recruit.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import recruit.domain.*;

@Component
public class DepartmentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Department>> {

    @Override
    public EntityModel<Department> process(EntityModel<Department> model) {
        return model;
    }
}
