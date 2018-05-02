package ar.com.indra.beconnected.service.implementationService;

import ar.com.indra.beconnected.model.Event;
import ar.com.indra.beconnected.dao.interfaceEventDAO;
import ar.com.indra.beconnected.service.interfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("interfaceService")
public class implementService implements interfaceService {

    @Autowired
    interfaceEventDAO interfaceDaoEvent;


    public void insertServiceEvent(Event event){

        interfaceDaoEvent.InsertEvent(event);

    }

    public List<Event> allServiceInsertEvent(){

       List<Event> serviceResp = interfaceDaoEvent.AllEventInsert();

       return serviceResp;
    }

}
