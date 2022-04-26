package com.example.demo.domain.pipeline;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Where.LIU
 * @since 2022/4/26
 */
public abstract class AbstractSalve implements Salve {
    @Getter
    @Setter
    private Salve nextSalve;

    public void invokeNextSalve(Context<?, ?> context) {
        if (nextSalve != null) {
            this.nextSalve.process(context);
        }
    }
}
