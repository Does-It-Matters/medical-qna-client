package com.example.medicalqnaclient.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Map;

public class JsonFormatter {
    public static String formatJson(Map<String, String> data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            return writer.writeValueAsString(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
