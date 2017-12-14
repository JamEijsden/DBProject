package exjobb.cache.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jimmie on 9/20/2017.
 */
@Configuration
public class MongoConfig{
    private String user = "jimmie";
    private String password = "Katat0nia";
    private String dbName="cache";
    private List<Converter<?,?>> converters = new ArrayList<Converter<?,?>>();

    protected String getDatabaseName() {
        return dbName;
    }

    @Bean
    public CustomConversions mongoCustomConversions() {
        return new CustomConversions(Collections.emptyList());
    }

    @Bean
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(user, dbName, password.toCharArray());

        ServerAddress serverAddress = new ServerAddress("35.157.192.42:27017");

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
                mongoClient(), getDatabaseName());

        return new MongoTemplate(simpleMongoDbFactory);
    }
}
