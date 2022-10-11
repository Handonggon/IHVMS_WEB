package kr.or.i815.ihvms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 return application.sources(MainApplication.class);
	}
	public static void main(String[] args) {
		final SpringApplicationBuilder builder = new SpringApplicationBuilder(MainApplication.class);
		
		builder.beanNameGenerator(new CustomBeanNameGenerator());
		builder.run(args);
	}
}