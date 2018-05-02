package ar.com.indra.beconnected.dao.implementEventDAO;

import ar.com.indra.beconnected.dao.interfaceEventDAO;

import ar.com.indra.beconnected.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("interfaceEventDAO")
public class EventDAO implements interfaceEventDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    public void InsertEvent(Event evento){

        mongoTemplate.insert(evento);
    }

    public List<Event> AllEventInsert(){
       List<Event> respList = mongoTemplate.findAll(Event.class);
       return respList;
    }

}
