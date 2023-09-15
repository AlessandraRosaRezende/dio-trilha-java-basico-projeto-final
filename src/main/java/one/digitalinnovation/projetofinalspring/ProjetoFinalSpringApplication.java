package one.digitalinnovation.projetofinalspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class ProjetoFinalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalSpringApplication.class, args);
	}

}
