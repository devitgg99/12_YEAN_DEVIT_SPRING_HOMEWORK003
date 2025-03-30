package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.entity.Venue;
import org.example.springhomework003.request.VenueRequest;

import java.util.List;

@Mapper
public interface venueRepository {

    @Results(
            id = "VenueMapper" , value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    }
    )
    @Select("""
        Select * from venues
        OFFSET #{page} LIMIT #{size};
    """)
    List<Venue> getAllVenue(Integer page, Integer size);

    @Select("""
        SELECT * FROM venues WHERE venue_id = #{id}
    """)
    @ResultMap("VenueMapper")
    Venue getVenueById(Integer id);

    @Select("""
        INSERT INTO venues (venue_id, venue_name, location)\s
        VALUES (default,#{req.venueName}, #{req.location})
        RETURNING *;
   \s""")
    @ResultMap("VenueMapper")
    Venue addVenue(@Param("req") VenueRequest venueRequest);

    @Select("""
        UPDATE venues 
        SET venue_name = #{req.venueName}, location = #{req.location}
        WHERE venue_id = #{id}
        RETURNING *;
    """)
    @ResultMap("VenueMapper")
    Venue updateVenueById(@Param("id") Long venueID, @Param("req") VenueRequest venueRequest);

    @Select("""
        DELETE FROM venues WHERE venue_id = #{venueID}
    """)
    Venue deleteVenueById(Long venueID);
}
