import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author likun
 * @version V1.0
 * @Title: PACKAGE_NAME
 * @date 2018/3/15 16:26
 */
public class Main {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.start();
        System.in.read();
    }
}
