import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.lk.dubbo.demo.service.GreetingService;
import com.lk.dubbo.demo.service.impl.GreetingServiceImpl;

/**
 * 服务层的api配置实现,代替Spring
 * 个人感觉代码太繁琐,如果有spring集成的情况下尽量不用硬编码的方式
 * @author likun
 * @version V1.0
 * @Title: PACKAGE_NAME
 * @date 2018/3/27 14:07
 */
public class ProviderApiMain {
    public static void main(String[] args) throws InterruptedException {
        /*接口实现*/
        GreetingService greetingService = new GreetingServiceImpl();

        /*application配置*/
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo-provider");

        /*注册中心配置,对应于consumer层*/
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setClient("zkclient");

        /*服务层配置,提供服务的协议信息*/
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreadpool("cached");
        protocolConfig.setThreads(100);

        /*provider的接口配置,聚合各种配置信息,同样ServiceConfig也是重对象*/
        ServiceConfig<GreetingService> serviceConfig = new ServiceConfig<GreetingService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(GreetingService.class);
        serviceConfig.setRef(greetingService);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.setGroup("dubbo");

        /*暴露以及注册服务*/
        serviceConfig.export();

        //挂起当前线程
        Thread.currentThread().join();

    }
}
