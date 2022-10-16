package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        // 2. Bean 조회
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A = A사용자가 10000원을 주문
        int userA = statefulService1.order("userA", 10000);
        // Thread B = B사용자가 20000원을 주문
        int userB = statefulService2.order("userB", 20000);

        // Thread A = 사용자A 주문 금액 조회
        // int price = statefulService2.getPrice();
        System.out.println("price = " + userA);

        // Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
    // 1. Bean 생성
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}