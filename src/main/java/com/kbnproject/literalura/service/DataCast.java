package com.kbnproject.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DataCast implements IDataCast {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T toObject(String json, Class<T> tClass) {
        try{
            if(json == null || json.trim().isEmpty()){
                throw new IllegalArgumentException("Json void");
            }
            return objectMapper.readValue(json, tClass);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
