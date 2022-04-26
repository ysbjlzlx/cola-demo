package com.example.demo.domain.pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/4/25
 */
public abstract class AbstractPipeline<I, R> {
    private final List<Salve> chains = new ArrayList<>();

    public R executor(I input) {
        Context<I, R> context = new Context<>(input);

        for (Salve salve : chains) {
            salve.process(context);
        }

        return context.getResult();
    }

    public void addChain(Salve salve) {
        this.chains.add(salve);
    }
}
