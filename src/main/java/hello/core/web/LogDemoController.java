package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// 로깅시 요청이 들어온 URL을 표시해주기 위한 컨트롤러
@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    // 수정1. MyLogger를 주입받는게 아닌 Logger를 찾을수있는 Dependency Lookup 주입
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    // HttpServletRequest = 클라이언트 요청을 받는 자바 표준 규약
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        /*
        ↓ URL을 MyLogger에 저장 하는 이 부분은 컨트롤러 보단 공동 처리가 가능한
        스프링 인터셉터나 서블릿 필터 등을 활용하는것이 좋다.
         */
        // 입력받은 URL을 requestURL에 담아주고
        // request scope인 myLogger에 입력받은 URL을 넣어줌
        // 수정2. Myloger를 getObject로 주입
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}