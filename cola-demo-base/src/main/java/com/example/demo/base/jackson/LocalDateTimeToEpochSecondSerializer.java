package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeToEpochSecondSerializer extends StdSerializer<LocalDateTime> {
    private final ZoneId zoneId;

    public LocalDateTimeToEpochSecondSerializer() {
        super(LocalDateTime.class);
        this.zoneId = ZoneId.systemDefault();
    }

    public LocalDateTimeToEpochSecondSerializer(@NotNull ZoneId zoneId) {
        super(LocalDateTime.class);
        this.zoneId = zoneId;
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (localDateTime != null) {
            long second = ZonedDateTime.of(localDateTime, zoneId).toEpochSecond();
            jsonGenerator.writeNumber(second);
        }
    }
}
