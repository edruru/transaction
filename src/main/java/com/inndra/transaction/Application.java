package com.inndra.transaction;



import com.inndra.transaction.dao.TransactionRepository;
import com.inndra.transaction.model.Transaction;
import com.inndra.transaction.util.RandomGenerator;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(TransactionRepository repository) {
		return args -> {
			repository.save(new Transaction(RandomGenerator.generateRandomNumberByUUID(),10.25, 1234L, LocalDate.now(), "des 1"));
			repository.save(new Transaction(RandomGenerator.generateRandomNumberByUUID(),10.60, 1234L, LocalDate.now(), "des 2"));
			repository.save(new Transaction(RandomGenerator.generateRandomNumberByUUID(),50.25, 1423L, LocalDate.now(), "des 3"));
		};
	}

	@Bean
	public Mapper mapper() {
		List<String> mappingFiles = new ArrayList();
		mappingFiles.add("dozerJdk8Converters.xml"); //solve issue with LocalDate java 8
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(mappingFiles);
		return dozerBeanMapper;
	}

}
