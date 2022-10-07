package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.forJson.Hits;

public class CustomParser {
    public static Hits PlacePars(String placeStr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        Hits hits = objectMapper.readValue(placeStr, Hits.class);
        return hits;
    }
    }
