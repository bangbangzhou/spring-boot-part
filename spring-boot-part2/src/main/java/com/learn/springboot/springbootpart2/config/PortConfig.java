package com.learn.springboot.springbootpart2.config;


import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: spring-boot-part2
 * @package: com.learn.springboot.springbootpart2.config
 * @classname: PortConfig
 * @description: 端口和web修改
 * @author: zbb
 * @create: 2022-02-15
 */
@Configuration
public class PortConfig {

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
//
//        return  new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableServletWebServerFactory factory) {
//                //设置web路径
//                factory.setContextPath("/webpath");
//                //设置端口
//                factory.setPort(8888);
//            }
//        };
//    }
//    @Bean
//    public ServletWebServerFactory  servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//
//        tomcat.setPort(8879);
//        tomcat.setContextPath("/webserver");
//        return tomcat;
//    }


//    @Bean
//    public ServletWebServerFactory  servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(connector());
//        return tomcat;
//    }
//
//    @Bean
//    public Connector connector(){
//        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8888);
//        connector.setURIEncoding("UTF-8");
//        connector.setMaxPostSize(8192);
//        connector.setSecure(false);
//        connector.setRedirectPort(8843);
//        return connector;
//    }
//    @Bean
//    public ServletWebServerFactory  jettyservletContainer() {
//        JettyServletWebServerFactory container = new JettyServletWebServerFactory();
//        container.setPort(8081);
//        // Context Path
//        container.setContextPath("/jettboot");
//        return container;
//    }

        @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){

        return  new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                if (TomcatEmbeddedServletContainerFactory.class.isAssignableFrom(factory.getClass())) {
                    TomcatEmbeddedServletContainerFactory tomcat =
                            TomcatEmbeddedServletContainerFactory.class.cast(container);
                    tomcat.setPort(8081);
                }
                if (JettyEmbeddedServletContainerFactory.class.isAssignableFrom(container.getClass())) {
                    JettyEmbeddedServletContainerFactory jetty =
                            JettyEmbeddedServletContainerFactory.class.cast(container);
                    jetty.setPort(8082);
                }
                if (UndertowEmbeddedServletContainerFactory.class.isAssignableFrom(container.getClass())) {
                    UndertowEmbeddedServletContainerFactory undertow =
                            UndertowEmbeddedServletContainerFactory.class.cast(container);
                    undertow.setPort(8083);
                }
                // Context Path
                container.setContextPath("/springboot");
                //设置web路径
                factory.setContextPath("/webpath");
                //设置端口
                factory.setPort(8888);
            }
        };
    }

}
