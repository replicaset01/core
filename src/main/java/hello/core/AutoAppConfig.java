package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Configuration Class를 제외하는 이유 = AppConfig 등 설정정보와의 충돌 방지
@ComponentScan(excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,
                classes=Configuration.class))
public class AutoAppConfig {

}
