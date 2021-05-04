package com.teste.tarefa3;


//import com.teste.tarefa3.controller.eventojsp;
import com.teste.tarefa3.controller.eventoController;
import com.teste.tarefa3.model.eventomodel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Tarefa3Application  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Tarefa3Application.class, args);
		//eventoController ev = context.getBean(eventoController.class);
		//ev.display();
		System.out.println("teste");
	}

/*
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Tarefa3Application.class, args);
		eventoController ev = context.getBean(eventoController.class);
		//ev.display();
		System.out.println("teste");
	}
*/
}
