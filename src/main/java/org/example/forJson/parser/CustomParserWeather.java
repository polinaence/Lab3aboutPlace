package org.example.forJson.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.forJson.weatherUtil.Weather;

public class CustomParserWeather {
    public static Weather PlaceWeather(String placeWeather) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ;
        Weather weather = objectMapper.readValue(placeWeather, Weather.class);
        return weather;
    }
}
