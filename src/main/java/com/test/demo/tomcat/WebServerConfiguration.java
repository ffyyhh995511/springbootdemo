package com.test.demo.tomcat;
import org.apache.catalina.connector.Connector;  
import org.apache.coyote.http11.Http11NioProtocol;  
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;  
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;  
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
/**
 * 自定义tomcat容器相关参数
 * @author Administrator
 *
 */
//@Configuration  
//application.properties 也可以定义，就不用了Configuration 这个配置了
public class WebServerConfiguration  
{  
    @Bean  
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory()  
    {  
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();  
        tomcatFactory.setPort(8888);  
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());  
        return tomcatFactory;  
    }  
}  
class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer  
{  
    public void customize(Connector connector)  
    {  
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();  
        //设置最大连接数  
        protocol.setMaxConnections(2000);  
        //设置最大线程数  
        protocol.setMaxThreads(2000);  
        protocol.setConnectionTimeout(30000);  
    }  
}  
