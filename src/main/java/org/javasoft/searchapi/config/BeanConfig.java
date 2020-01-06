package org.javasoft.searchapi.config;

import lombok.val;
import org.apache.http.impl.client.HttpClientBuilder;
import org.javasoft.searchapi.bean.RestTemplateBean;
import org.javasoft.searchapi.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Configuration
public class BeanConfig {

    private final TravelBetaConfig travelBetaConfig;

    @Autowired
    public BeanConfig(TravelBetaConfig travelBetaConfig) {
        this.travelBetaConfig = travelBetaConfig;
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE, proxyMode = TARGET_CLASS)
    public RestTemplateBean restTemplateBean() {

        val clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        clientHttpRequestFactory.setConnectTimeout(2000);
        clientHttpRequestFactory.setReadTimeout(10000);

        val restTemplate = new RestTemplate(clientHttpRequestFactory);
        val converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));

        val mappingJackson2XmlHttpMessageConverter = new MappingJackson2XmlHttpMessageConverter();
        mappingJackson2XmlHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));

        restTemplate.getMessageConverters().add(mappingJackson2XmlHttpMessageConverter);
        restTemplate.getMessageConverters().add(converter);
        restTemplate.getMessageConverters().addAll(getMessageConverters());
        restTemplate.getInterceptors().add(new GzipAcceptHeaderRequestInterceptor());
        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        val restTemplateBean = new RestTemplateBean();
        restTemplateBean.setRestTemplate(restTemplate);
        restTemplateBean.setBaseURL(travelBetaConfig.getBaseUrl());
        restTemplateBean.setHostURL(travelBetaConfig.getHostUrl());


        return restTemplateBean;
    }
    private List<HttpMessageConverter<?>> getMessageConverters() {
        val marshaller = new XStreamMarshaller();
        val marshallingConverter =  new MarshallingHttpMessageConverter(marshaller);

       val converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(marshallingConverter);
        return converters;
    }

    public static class GzipAcceptHeaderRequestInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            request.getHeaders().set(HttpHeaders.ACCEPT_ENCODING, "gzip");
            return execution.execute(request, body);
        }
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE, proxyMode = TARGET_CLASS)
    public EncodeUtil encodeUtil(){
        return new EncodeUtil();
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);

        final JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
        connectionFactory.setUsePool(true);
        connectionFactory.setHostName("172.104.156.136");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        final RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }


}
