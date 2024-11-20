package recruit.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import recruit.config.kafka.KafkaProcessor;
import recruit.domain.*;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRecruitRegistered_then_CREATE_1(
        @Payload RecruitRegistered recruitRegistered
    ) {
        try {
            if (!recruitRegistered.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(recruitRegistered.getId());
            myPage.setEmail(recruitRegistered.getEmail());
            myPage.setName(recruitRegistered.getName());
            myPage.setJobId(recruitRegistered.getJobId());
            myPage.setContents(recruitRegistered.getContents());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPassed_then_CREATE_2(@Payload Passed passed) {
        try {
            if (!passed.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setPassYn(passed.getPassYn());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFailed_then_CREATE_3(@Payload Failed failed) {
        try {
            if (!failed.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setPassYn(failed.getPassYn());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPassed_then_UPDATE_1(@Payload Passed passed) {
        try {
            if (!passed.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                passed.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPassYn(passed.getPassYn());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFailed_then_UPDATE_2(@Payload Failed failed) {
        try {
            if (!failed.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                failed.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setPassYn(failed.getPassYn());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
