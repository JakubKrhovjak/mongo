package com.example.demo;

import com.example.demo.entity.Item;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
//		ReactiveMongoOperations mongoOps = new ReactiveMongoOperations(new SimpleReactiveMongoDatabaseFactory( MongoClients.create("mongodb://localhost:27018"), "test-data"));
//		Item item = new Item().setName("name2").setDescription("desc2").setStatus(Item.Status.FULL);
//		mongoOps.insert(item);
//
//	}

//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create("mongodb://localhost:27018");
//    }
//
//	public @Bean
//	ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
//		return new SimpleReactiveMongoDatabaseFactory(mongoClient(), "test-data");
//	}
//
//	public @Bean
//	ReactiveMongoTemplate reactiveMongoTemplate() {
//		return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
//	}

//	public @Bean
//	MongoTemplate mongoTemplate() {
//		return new MongoTemplate(mongoClient(), "test-data");
//	}
}
