import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.lk.dubbo.demo.service.GreetingService;

import java.util.concurrent.Future;

/**
 * 用dubbo自身的启动方法不经过Spring实现
 * @author likun
 * @version V1.0
 * @Title: PACKAGE_NAME
 * @date 2018/3/27 13:50
 */
public class ApiMain {
    public static void main(String[] args) {
        /*application配置*/
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-demo-consumer");

        /*注册中心配置*/
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("127.0.0.1:2181");
        registry.setClient("zkclient");

        /*客户端订阅注册中心配置,ReferenceConfig为重对象内部封装了各种连接*/
        ReferenceConfig<GreetingService> referenceConfig = new ReferenceConfig<GreetingService>();
        referenceConfig.setApplication(application);
        referenceConfig.setRegistry(registry);
        referenceConfig.setLoadbalance("roundrobin");
        referenceConfig.setInterface(GreetingService.class);
        referenceConfig.setVersion("1.0.0");
        referenceConfig.setGroup("dubbo");

        GreetingService greetingService = referenceConfig.get();
        System.out.println(greetingService.hello("world"));

    }
}

