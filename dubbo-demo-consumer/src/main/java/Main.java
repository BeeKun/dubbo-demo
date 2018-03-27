import com.lk.dubbo.demo.service.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

/**
 * 请求服务提供方的接口方法,如果整合Spring-boot则通过@Reference调用
 * @author likun
 * @version V1.0
 * @Title: PACKAGE_NAME
 * @date 2018/3/15 16:42
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        GreetingService greetingService = (GreetingService) context.getBean("greetingService");
        String greetMessage = greetingService.hello("world");
        System.out.println("Consumer请求信息 ==> " + greetMessage);
        context.destroy();
    }
}
