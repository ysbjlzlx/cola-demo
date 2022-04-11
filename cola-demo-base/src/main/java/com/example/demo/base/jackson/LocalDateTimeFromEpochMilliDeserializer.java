package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 将 13 位时间戳转为 LocaleDateTime
 *
 * @author where
 */
public class LocalDateTimeFromEpochMilliDeserializer extends StdDeserializer<LocalDateTime> {
    private final ZoneId zoneId;

    public LocalDateTimeFromEpochMilliDeserializer() {
        super(LocalDateTime.class);
        this.zoneId = ZoneId.systemDefault();
    }

    public LocalDateTimeFromEpochMilliDeserializer(ZoneId zoneId) {
        super(LocalDateTime.class);
        this.zoneId = zoneId;
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (null != jsonParser) {
            long epochMilli = jsonParser.getValueAsLong();
            Instant instant = Instant.ofEpochMilli(epochMilli);
            return ZonedDateTime.ofInstant(instant, zoneId).toLocalDateTime();
        }
        return null;
    }
}
