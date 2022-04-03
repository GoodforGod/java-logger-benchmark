package io.goodforgod.benchmark;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

/**
 * Log4j benchmark
 *
 * @author Anton Kurako (GoodforGod)
 * @since 09.03.2022
 */
public abstract class Log4jLoggerBenchmark extends LoggerBenchmark {

    protected Log4jLoggerBenchmark() {}

    private Logger logger;
    private String arg1;
    private String arg2;
    private String arg3;
    private Exception exception;

    @Setup
    public void setup() {
        try {
            throwEx();
        } catch (Exception e) {
            exception = e;
        }

        arg1 = "FirstArgument";
        arg2 = "SecondArgument";
        arg3 = "ThirdArgument";
        logger = LogManager.getLogger(LoggerBenchmark.class);
    }

    @Benchmark
    public void messageOneArgumentInEnd() {
        logger.info(
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {}",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInEnd() {
        logger.info(
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {} and {}",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInEnd() {
        logger.info(
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {} and {} and {}",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInStart() {
        logger.info(
                "{} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInStart() {
        logger.info(
                "{} and {} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInStart() {
        logger.info(
                "{} and {} and {} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInMiddle() {
        logger.info(
                "this long message is supposed to represent logging message with arguments {} most developers use in their daily routing to represent most common scenarios",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInMiddle() {
        logger.info(
                "this long message is supposed to represent logging message with arguments {} and {} most developers use in their daily routing to represent most common scenarios",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInMiddle() {
        logger.info(
                "this long message is supposed to represent logging message with arguments {} and {} and {} most developers use in their daily routing to represent most common scenarios",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageWithoutArguments() {
        logger.info(
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios without arguments");
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.info(
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with stacktrace",
                exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Unknown exception happened and have medium size stacktrace");
    }
}
