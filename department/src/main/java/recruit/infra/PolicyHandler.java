package recruit.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import recruit.config.kafka.KafkaProcessor;
import recruit.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DepartmentRepository departmentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='HrStarted'"
    )
    public void wheneverHrStarted_Notify(@Payload HrStarted hrStarted) {
        HrStarted event = hrStarted;
        System.out.println("\n\n##### listener Notify : " + hrStarted + "\n\n");

        // Sample Logic //
        Department.notify(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
