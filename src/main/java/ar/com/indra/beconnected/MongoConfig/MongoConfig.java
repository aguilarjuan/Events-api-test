package ar.com.indra.beconnected.MongoConfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages = "ar.com.indra.beconnected")
public class MongoConfig  {

    @Value("${spring.data.mongodb.user}")
    private String userName;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.password}")
    private String password;


    @Bean
    public MongoDbFactory getMongoDbFactory() {


        ServerAddress serverAddres = new ServerAddress(host, port);
        List<MongoCredential> credentialsList = new ArrayList<>();

        credentialsList.add(MongoCredential.createCredential(userName, database, password.toCharArray()));

        return new SimpleMongoDbFactory(new MongoClient(serverAddres, credentialsList), database);
    }


    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MappingMongoConverter converter =
                new MappingMongoConverter(getMongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory(),converter);
        return mongoTemplate;
    }


}
