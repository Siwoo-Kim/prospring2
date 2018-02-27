package com.siwoo.application.formatter;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;


import javax.annotation.PostConstruct;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditorRegistrar implements PropertyEditorRegistrar {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
    private String dateFormat = DEFAULT_DATE_PATTERN;


    public LocalDateEditorRegistrar(String dateFormatPattern) {
        dateTimeFormatter.ofPattern(dateFormatPattern);
    }

    private static class LocalDateEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue( LocalDate.parse(text,dateTimeFormatter) );
        }
    }

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(LocalDate.class,new LocalDateEditor());
    }
}
