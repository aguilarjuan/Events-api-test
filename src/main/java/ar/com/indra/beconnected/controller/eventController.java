package ar.com.indra.beconnected.controller;

import ar.com.indra.beconnected.model.Event;
import ar.com.indra.beconnected.service.interfaceService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@RestController
@RequestMapping("/beconnected")
public class eventController {

    private  interfaceService service;

    @Autowired
    public void eventController(interfaceService service){
        this.service = service;
    }

    @RequestMapping(value = "/insertEvent", method = RequestMethod.POST, consumes = "application/json")
    public void insertEvent(@RequestBody Event Evento ){
        service.insertServiceEvent(Evento);
    }

    @RequestMapping(value = "/returnEventInsert", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Event> allEventInsert(){
        List<Event> respController = service.allServiceInsertEvent();
                return respController;
    }
}
