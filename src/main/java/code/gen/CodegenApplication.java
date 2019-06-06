package code.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CodegenApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
//		SpringApplication.run(CodegenApplication.class, args);
		SpringApplication app = new SpringApplication(EdukanWebConfig.class);
		app.run(CodegenApplication.class, args);
	}

}
