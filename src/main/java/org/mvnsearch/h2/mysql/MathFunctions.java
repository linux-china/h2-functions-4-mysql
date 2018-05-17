package org.mvnsearch.h2.mysql;

/**
 * math functions
 *
 * @author linux_china
 */
public class MathFunctions {

    public static Integer ceil(Double number) {
        return Double.valueOf(Math.ceil(number)).intValue();
    }
}
