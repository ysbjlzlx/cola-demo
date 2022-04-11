package com.example.demo.base.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Number 类型值校验, 只做数值判断，不做数据类型判断
 * 支持入参数据类型：byte, short, int, long, float, double
 *
 * @author where.liu
 */
public class NumberUtils {
    /**
     * 校验入参是否为 > 0 的正数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    @Contract(value = "null -> false", pure = true)
    public static boolean isPositive(@Nullable Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) > 0;
    }

    /**
     * 校验入参是否为 >= 0 的正数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    @Contract(value = "null -> false", pure = true)
    public static boolean isPositiveOrZero(@Nullable Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) >= 0;
    }

    /**
     * 校验入参是否为 < 0 的负数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    @Contract(value = "null -> false", pure = true)
    public static boolean isNegative(@Nullable Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) < 0;
    }

    /**
     * 校验入参是否为 <= 0 的负数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    @Contract(value = "null -> false", pure = true)
    public static boolean isNegativeOrZero(@Nullable Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) <= 0;
    }

    /**
     * a < b
     *
     * @return true or false
     */
    @Contract(value = "null,_ -> false; _,null -> false", pure = true)
    public static boolean lt(@Nullable Number a, @Nullable Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) < 0;
    }

    /**
     * a <= b
     *
     * @return true or false
     */
    @Contract(value = "null,_ -> false; _,null -> false", pure = true)
    public static boolean le(@Nullable Number a, @Nullable Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) <= 0;
    }

    /**
     * a == b
     *
     * @return true or false
     */
    @Contract(value = "null,_ -> false; _,null -> false", pure = true)
    public static boolean eq(@Nullable Number a, @Nullable Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) == 0;
    }

    /**
     * a > b
     *
     * @return true or false
     */
    @Contract(value = "null,_ -> false; _,null -> false", pure = true)
    public static boolean gt(@Nullable Number a, @Nullable Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) > 0;
    }

    /**
     * a >= b
     *
     * @return true or false
     */
    @Contract(value = "null,_ -> false; _,null -> false", pure = true)
    public static boolean ge(@Nullable Number a, @Nullable Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) >= 0;
    }
}

