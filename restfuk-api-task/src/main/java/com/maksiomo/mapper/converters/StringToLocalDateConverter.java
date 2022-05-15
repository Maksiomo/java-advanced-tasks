package com.maksiomo.mapper.converters;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateConverter extends CustomConverter<String, LocalDate> {
    public static final String CONVERTER_CODE = "StringToLocalDateConverter";

    @Override
    public LocalDate convert(String s, Type<? extends LocalDate> type, MappingContext arg2) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}
