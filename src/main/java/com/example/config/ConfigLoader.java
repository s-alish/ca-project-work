package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigLoader {
    public static Configuration loadConfig(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), Configuration.class);
    }
}
