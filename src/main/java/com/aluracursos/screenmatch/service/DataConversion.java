package com.aluracursos.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for converting JSON data to Java objects.
 * It implements the IDataConversion interface.
 */
public class DataConversion implements IDataConversion {
    // ObjectMapper is a class from the Jackson library used for converting JSON to/from Java objects
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * This method takes a JSON string and a class type as parameters,
     * and converts the JSON string to an object of the given class type.
     *
     * @param json   The JSON string to be converted.
     * @param tClass The class type to which the JSON string should be converted.
     * @return An object of type T, where T is the class type passed as a parameter.
     * @throws RuntimeException If there is an error during the conversion process.
     */
    @Override
    public <T> T obtainData(String json, Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}