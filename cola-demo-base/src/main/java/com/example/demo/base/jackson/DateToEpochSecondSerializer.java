package com.example.demo.base.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author where
 */
public class DateToEpochSecondSerializer extends StdSerializer<Date> {
    private final ZoneId zoneId;

    public DateToEpochSecondSerializer() {
        super(Date.class);
        this.zoneId = ZoneId.systemDefault();
    }

    public DateToEpochSecondSerializer(@NotNull ZoneId zoneId) {
        super(Date.class);
        this.zoneId = zoneId;
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (date != null) {
            long second = ZonedDateTime.ofInstant(date.toInstant(), zoneId).toEpochSecond();
            jsonGenerator.writeNumber(second);
        }
    }
}
