package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToISO8601Serializer extends StdSerializer<LocalDateTime> {
    private final ZoneId zoneId;

    public LocalDateTimeToISO8601Serializer() {
        super(LocalDateTime.class);
        this.zoneId = ZoneId.systemDefault();
    }

    protected LocalDateTimeToISO8601Serializer(@NotNull ZoneId zoneId) {
        super(LocalDateTime.class);
        this.zoneId = zoneId;
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (localDateTime == null) {
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
        String str = ZonedDateTime.of(localDateTime, zoneId).format(dtf);
        jsonGenerator.writeString(str);
    }
}
