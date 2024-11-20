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
    HrRepository hrRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RecruitRegistered'"
    )
    public void wheneverRecruitRegistered_HrStart(
        @Payload RecruitRegistered recruitRegistered
    ) {
        RecruitRegistered event = recruitRegistered;
        System.out.println(
            "\n\n##### listener HrStart : " + recruitRegistered + "\n\n"
        );

        // Sample Logic //
        Hr.hrStart(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
