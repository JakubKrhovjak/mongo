package com.example.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

//    @PostConstruct
//	public void init() {
//		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDbFactory(mongoClient(), "test-data"));
//		Item item = new Item().setName("name").setDescription("desc");
//		mongoOps.insert(item);
//
//	}

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27018");
    }


	public @Bean
	MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "test-data");
	}
}
