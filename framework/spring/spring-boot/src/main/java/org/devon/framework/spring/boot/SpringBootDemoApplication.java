package org.devon.framework.spring.boot;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}


	/**
	 * 明文http2协议服务
	 */
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer(){
		return factory -> {
			Connector connector = new Connector();
			connector.addUpgradeProtocol(new Http2Protocol());
			connector.setPort(8080);
			factory.addAdditionalTomcatConnectors(connector);
		};
	}
}
