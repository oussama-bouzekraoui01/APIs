package com.example.apis.GoogleCalendar;


import com.google.api.services.calendar.model.Event;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/calendar")
public class CalendarController {


    public final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping(path = "{start}/{end}")
    public List<Event> getEvent(@PathVariable("start") String start, @PathVariable String end) throws GeneralSecurityException, IOException {
        return calendarService.getEvent(start, end);
    }

    @PostMapping
    public void addNewEvent(@RequestBody EventParam eventParam) throws GeneralSecurityException, IOException {
        calendarService.addNewEvent(eventParam);
    }

    @DeleteMapping(path = "{eventID}")
    public void deleteEvent(@PathVariable("eventID") String eventID) throws GeneralSecurityException, IOException {
        calendarService.deleteEvent(eventID);
    }


   @PutMapping(path = "{eventID}")
    public void updateEvent(@PathVariable("eventID") String eventID, @RequestBody EventParam eventParam) throws GeneralSecurityException, IOException {
        calendarService.updateEvent(eventID, eventParam);
    }


}
