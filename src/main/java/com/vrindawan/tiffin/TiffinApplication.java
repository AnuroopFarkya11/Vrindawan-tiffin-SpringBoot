package com.vrindawan.tiffin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TiffinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiffinApplication.class, args);
	}

	@Bean
	public TransactionManager transactionManager(MongoDatabaseFactory factory) {
		return new MongoTransactionManager(factory);
	}

}

//mongosh "mongodb+srv://cluster0.r1dfw.mongodb.net/" --apiVersion 1 --username anuroopf02
