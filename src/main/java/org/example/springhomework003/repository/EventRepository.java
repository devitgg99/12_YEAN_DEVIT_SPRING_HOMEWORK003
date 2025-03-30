package org.example.springhomework003.repository;

import jakarta.validation.constraints.Positive;
import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.entity.Event;
import org.example.springhomework003.request.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {
    @Results(
            id = "eventMapper", value = {
                    @Result(property = "eventId" , column = "event_id"),
                    @Result(property = "eventName" , column = "event_name"),
                    @Result(property = "eventDate" , column = "event_date"),
                    @Result(property = "venue" , column = "venue_id" ,
                            one = @One(select = "org.example.springhomework003.repository.venueRepository.getVenueById"
                    )),
                    @Result(property = "attendees" , column = "event_id",
                            many = @Many(select = "org.example.springhomework003.repository.EventAttendeeRepository.getAttendeeById"))
    }
    )
    @Select("""
        SELECT * FROM events
        OFFSET #{page} LIMIT #{size};
    """)
    List<Event> getAllEvents(@Positive Integer page, @Positive Integer size);

    @Select("""
        Select * from events where event_id = #{eventId}
    """)
    @ResultMap("eventMapper")
    Event getEventById(Integer eventId);

    @Select("""
        INSERT INTO events (event_id, event_name, event_date, venue_id) 
        VALUES (default, #{req.eventName}, #{req.eventDate}, #{req.venueId})
        RETURNING *;
    """)
    @ResultMap("eventMapper")
    Event addEvent(@Param("req") EventRequest eventRequest);

    @Select("""
        Update events 
        SET event_name = #{req.eventName}, event_date = #{req.eventDate}, venue_id = #{req.venueId}
        where event_id = #{eventID}
    """)
    @ResultMap("eventMapper")
    Event updateEventByEventId(Long eventID, @Param("req")EventRequest eventRequest);

    @Select("""
        Delete from events where event_id = #{eventID}
    """)
    Event deleteEventByEventId(Long eventID);
}
