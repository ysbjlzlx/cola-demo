package com.example.demo.domain.pipeline;

/**
 * @author Where.LIU
 * @since 2022/4/25
 */
public interface Salve {
    /**
     * 任务处理函数
     *
     * @param context 入参，响应
     */
    void process(Context<?, ?> context);
}
