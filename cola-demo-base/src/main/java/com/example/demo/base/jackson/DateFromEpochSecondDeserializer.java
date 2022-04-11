package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;

public class DateFromEpochSecondDeserializer extends StdDeserializer<Date> {
    protected DateFromEpochSecondDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (null == jsonParser) {
            return null;
        }
        String value = jsonParser.getValueAsString();

        if (StringUtils.isNotBlank(value) && StringUtils.isNumeric(value)) {
            return new Date(Long.parseLong(value) * 1000);
        }

        return null;
    }
}
