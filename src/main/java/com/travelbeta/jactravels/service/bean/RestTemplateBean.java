package com.travelbeta.jactravels.service.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

@Slf4j
public class RestTemplateBean {

    @Getter @Setter
    private RestTemplate restTemplate;

    @Getter @Setter
    private String baseURL;

    @Getter @Setter
    private String hostURL;

    public String postRequestObject(String request){
        MultiValueMap<String, String> requestMap= new LinkedMultiValueMap<>();
        requestMap.add("Data" , request);
        val httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add("Accept-Encoding", "gzip, deflate");
        httpHeaders.add("Host", hostURL);
        val httpRequestEntity = new HttpEntity<MultiValueMap<String, String>>(requestMap, httpHeaders);
        //log.info("Testing  {}", "=====================");
        val responseEntity = restTemplate.exchange(baseURL, HttpMethod.POST, httpRequestEntity, byte[].class);
        log.info("Status Code :::: {}" , responseEntity.getStatusCode());
        log.info("has Body :::: {}" , responseEntity.hasBody());
        log.info("Content Type :::: {}" , responseEntity.getHeaders().getContentType().getType());
        //System.out.println(" \n\n Response Body :::::: " + responseEntity.getBody() + " \n\n ");

        BufferedReader rd = new BufferedReader( new InputStreamReader(new ByteArrayInputStream(responseEntity.getBody())));
        StringBuilder result = new StringBuilder();
        try{
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
           // System.out.println(" \n\n " + result.toString());
        }catch (Exception ex){
            log.error("Exception Occurred : {}", ex);
        }
        //return responseEntity.getBody();
        return result.toString();
    }

}
