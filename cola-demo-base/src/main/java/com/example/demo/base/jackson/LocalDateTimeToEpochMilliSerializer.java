package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 将 LocalDateTime 转位 13 时间戳
 */
public class LocalDateTimeToEpochMilliSerializer extends StdSerializer<LocalDateTime> {
    private final ZoneId zoneId;

    public LocalDateTimeToEpochMilliSerializer() {
        super(LocalDateTime.class);
        this.zoneId = ZoneId.systemDefault();
    }

    public LocalDateTimeToEpochMilliSerializer(ZoneId zoneId) {
        super(LocalDateTime.class);
        this.zoneId = zoneId;
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (null != localDateTime) {
            long epochMilli = ZonedDateTime.of(localDateTime, zoneId).toInstant().toEpochMilli();
            jsonGenerator.writeNumber(epochMilli);
        }
    }
}
