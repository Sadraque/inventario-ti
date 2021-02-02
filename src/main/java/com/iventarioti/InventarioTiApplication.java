package com.iventarioti;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iventarioti.domain.Cidade;
import com.iventarioti.domain.Colaborador;
import com.iventarioti.domain.Cpu;
import com.iventarioti.domain.Endereco;
import com.iventarioti.repositories.CidadeRepository;
import com.iventarioti.repositories.ColaboradorRepository;
import com.iventarioti.repositories.CpuRepository;
import com.iventarioti.repositories.EnderecoRepository;

@SpringBootApplication
public class InventarioTiApplication  implements CommandLineRunner {
	
	@Autowired
	EnderecoRepository enderecoRepositoty;
	
	@Autowired
	CidadeRepository cidadeRepositoty;
	
	@Autowired
	CpuRepository cpuRepositoty;
	
	@Autowired
	ColaboradorRepository colaboradorRepositoty;
	
	public static void main(String[] args) {
		SpringApplication.run(InventarioTiApplication.class, args);	
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade cidade1 = new Cidade(100, "Belo Horizonte", "MG");
		cidadeRepositoty.saveAll(Arrays.asList(cidade1));
		
		Endereco endereco1 = new Endereco("Rua Palácio da Liberdade", 78, "Piratininga", 31573360, cidade1);
		enderecoRepositoty.saveAll(Arrays.asList(endereco1));
		
		Colaborador sadraque = new Colaborador("Sadraque", "Nunes", "sadraquenunesmartiniano@gmail.com", "31 9 83131461", "TI", endereco1);
		colaboradorRepositoty.saveAll(Arrays.asList(sadraque));
		
		Cpu notebook = new Cpu("Dell", "Inspiron", 2018, "123", "i5", 12, 2000, 512, "", sadraque);
		cpuRepositoty.saveAll(Arrays.asList(notebook));
		
	}

}
