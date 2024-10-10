package atividade_marcio_03.com.example.atividade_marcio_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="atividade_marcio_03.com.example.atividade_marcio_03.models")
public class AtividadeMarcio03Application {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeMarcio03Application.class, args);
	}

}
