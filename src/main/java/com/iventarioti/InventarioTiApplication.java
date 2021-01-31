package com.iventarioti;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iventarioti.domain.Colaborador;
import com.iventarioti.domain.Cpu;
import com.iventarioti.repositories.ColaboradorRepository;
import com.iventarioti.repositories.CpuRepository;

@SpringBootApplication
public class InventarioTiApplication  implements CommandLineRunner {
	
	@Autowired
	CpuRepository cpuRepositoty;
	
	@Autowired
	ColaboradorRepository colaboradorRepositoty;
	
	public static void main(String[] args) {
		SpringApplication.run(InventarioTiApplication.class, args);	
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Colaborador sadraque = new Colaborador("Sadraque", "Nunes", "sadraquenunesmartiniano@gmail.com", "31 9 83131461", "TI");
		colaboradorRepositoty.saveAll(Arrays.asList(sadraque));
		
		Cpu notebook = new Cpu("Dell", "Inspiron", 2018, "123", "i5", 12, 2000, 512, "");
		notebook.setColaborador(sadraque);
		cpuRepositoty.saveAll(Arrays.asList(notebook));
		
	}

}
