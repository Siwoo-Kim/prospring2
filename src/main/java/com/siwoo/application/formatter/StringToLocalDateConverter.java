package com.siwoo.application.formatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateConverter implements Converter<String,LocalDate> {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateTimeFormatter;
    private String datePattern = DEFAULT_DATE_PATTERN;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        if(StringUtils.hasText(datePattern))
            this.datePattern = datePattern;
    }

    @PostConstruct
    public void init(){
        System.out.println(datePattern);
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source,dateTimeFormatter);
    }
}
