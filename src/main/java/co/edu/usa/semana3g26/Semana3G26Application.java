package co.edu.usa.semana3g26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.edu.usa.semana3g26.modelo"})
@SpringBootApplication
public class Semana3G26Application {
//TODOS A SUBIR RETO 3 Y 4!!!
	public static void main(String[] args) {
		SpringApplication.run(Semana3G26Application.class, args);
	}

}
