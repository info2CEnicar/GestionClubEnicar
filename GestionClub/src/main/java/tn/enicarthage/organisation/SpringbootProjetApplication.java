package tn.enicarthage.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringbootProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjetApplication.class, args);
	}

}
