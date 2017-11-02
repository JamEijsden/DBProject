package exjobb.cache.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

/**
 * Created by Jimmie on 9/20/2017.
 */
@Configuration
public class MongoConfig {
    private String user = "jimmie";
    private String password = "Katat0nia";
    private String dbName="cache";




    @Bean
    public MongoDbFactory mongoFactory() throws Exception {
        MongoCredential credential = MongoCredential.createCredential(user, dbName, password.toCharArray());

        ServerAddress serverAddress = new ServerAddress("52.29.128.68:27017");

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
                mongoClient, dbName);

        return simpleMongoDbFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoFactory());
    }
}
