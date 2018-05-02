package ar.com.indra.beconnected.dao;

import ar.com.indra.beconnected.model.Event;

import java.util.List;

public interface interfaceEventDAO {

    public void InsertEvent(Event evento);

    public List<Event> AllEventInsert();

}
