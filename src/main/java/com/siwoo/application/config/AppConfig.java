package com.siwoo.application.config;

import com.siwoo.application.domain.Singer;
import com.siwoo.application.formatter.StringToLocalDateConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:/META-INF/app-properties/application.properties")
public class AppConfig {

    @Value("${date.format.pattern}")
    private String dateFormatPattern;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public Singer john(
            @Value("${countrySinger.firstName}") String firstName,
            @Value("${countrySinger.lastName}") String lastName,
            @Value("${countrySinger.birthDate}") LocalDate birthDate,
            @Value("${countrySinger.personalSite}") URL personalSite
            ){
        Singer singer = new Singer();
        singer.setFirstName(firstName);
        singer.setLastName(lastName);
        singer.setBirthDate(birthDate);
        singer.setPersonalSite(personalSite);
        return singer;
    }

    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(converter());
        conversionServiceFactoryBean.setConverters(converters);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    public Converter converter() {
        StringToLocalDateConverter converter = new StringToLocalDateConverter();
        converter.setDatePattern(dateFormatPattern);
        converter.init();
        return converter;
    }


}
