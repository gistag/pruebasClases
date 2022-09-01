package com.udeA.Ciclo3;

import com.udeA.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class Ciclo3Application {



	@GetMapping("/test")
	public String test(){

		Empresa emp = new Empresa("SOLAR SAS", "Calle la geta","3213213211", "800212121");
		emp.setNombre("SOLAR LTDA");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
		//System.out.println("Hola Mundo");

	}


}
