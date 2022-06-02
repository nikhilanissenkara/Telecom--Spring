package org.telecom.telecom_domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceScriptDatabaseInitializer;

@SpringBootApplication
public class TelecomDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomDomainApplication.class, args);
	}

}
