package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.entity.Attendee;
import org.example.springhomework003.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("""
        Select * from attendees
        OFFSET #{page} LIMIT #{size};
    """)
    @Results(
            id = "attendeeMapper", value = {
                    @Result(property = "attendeeId" , column = "attendee_id"),
                    @Result(property = "attendeeName", column = "attendee_name")
    }
    )
    List<Attendee> getAllAttendee(Integer page, Integer size);

    @Select("""
        select * from attendees where attendee_id = #{attendeeId}
    """)
    @ResultMap("attendeeMapper")
    Attendee getAttendeeById(Long attendeeId);

    @Select("""
        INSERT INTO attendees (attendee_id, attendee_name,email)\s
        VALUES (default,#{req.attendeeName},#{req.email})
        RETURNING *;
   \s""")
    @ResultMap("attendeeMapper")
    Attendee addAttendee(@Param("req") AttendeeRequest attendeeRequest);

    @Select("""
        Update attendees 
        SET attendee_name = #{req.attendeeName} ,email = #{req.email}
        where attendee_id = #{attendeeId}
        RETURNING *;
    """)
    @ResultMap("attendeeMapper")
    Attendee updateAttendeeById(Integer attendeeId,@Param("req") AttendeeRequest attendeeRequest);


    @Select("""
        Delete from attendees where attendee_id = #{attendeeID}
    """)
    Attendee deleteAttendeeById(Integer attendeeID);
}
