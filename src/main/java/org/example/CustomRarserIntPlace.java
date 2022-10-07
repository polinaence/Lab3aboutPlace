package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.forJson.intPlace.NearBy;
import org.example.forJson.intPlace.NearFeatures;

import java.util.List;


public class CustomRarserIntPlace {
    public static NearFeatures PlaceIntr (String PlaceIntr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        NearFeatures NearPlace = objectMapper.readValue(PlaceIntr, NearFeatures.class);
        return NearPlace;
    }
}