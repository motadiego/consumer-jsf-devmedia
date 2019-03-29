package br.com.diegomota.cursojsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.diegomota.cursojsf.dto.NotaDTO;
import br.com.diegomota.cursojsf.rest.NotaRestConsumer;

@SpringBootApplication
public class CursojsfApplication extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	private NotaRestConsumer notaRest; 
	
	public static void main(String[] args) {
		SpringApplication.run(CursojsfApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CursojsfApplication.class);
	}
	


	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("IMPRIMIR ALGUMA COISA");
		
	}
}
