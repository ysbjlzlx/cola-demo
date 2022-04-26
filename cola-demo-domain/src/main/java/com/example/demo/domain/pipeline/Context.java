package com.example.demo.domain.pipeline;

import lombok.Data;

/**
 * @author Where.LIU
 * @since 2022/4/25
 */
@Data
public class Context<I, R> {
    private I input;
    private R result;

    public Context(I input) {
        this.input = input;
    }
}
