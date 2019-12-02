package org.javasoft.searchapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class EncodeUtil<I,O> {

    public String convertObjectToEncodedString(I input){
        String encodeString = "";
        String xmlString = "";
        val xmlMapper = new XmlMapper();
        try {
            xmlMapper.registerModule(new JaxbAnnotationModule());
            xmlString = xmlMapper.writeValueAsString(input);
        } catch (Exception e) {
            log.error("Error while converting Object to String ::: {}", e);
        }finally {
            return xmlString;
        }
    }

    public O convertEncodedStringToObject(String encodedString , O output){
        try {
            //log.info("\n\n Encoded response String :::: {}\n\n", encodedString);
            val xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JaxbAnnotationModule());
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
           return  (O)xmlMapper.readValue(encodedString, output.getClass());
        }catch (Exception e) {
            log.error("Error while converting Object to String ::: {}", e);
            return null;
        }
    }
}
