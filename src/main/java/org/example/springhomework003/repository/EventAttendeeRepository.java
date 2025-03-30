package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.entity.Attendee;

import java.util.List;

@Mapper
public interface EventAttendeeRepository {

    @Results(
            id = "attendeeMapper", value = {
            @Result(property = "attendeeId" , column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    }
    )
    @Select("""
        SELECT a.* FROM attendees a
        INNER JOIN event_attendee e ON a.attendee_id = e.attendee_id
        WHERE e.event_id = #{eventId}
    """)
    List<Attendee> getAttendeeById(@Param("event-id") Long eventId);


    @Select("""
        INSERT INTO event_attendee (id, event_id, attendee_id) 
        VALUES (default, #{eventId},#{attendeeId})
    """)
    Long addIntoEventAttendee(Long eventId, Long attendeeId);

    @Select("""
        DELETE FROM event_attendee where event_id = #{eventID}
    """)
    void deleteEventAttendee(@Param("eventID") Long eventID);
}
