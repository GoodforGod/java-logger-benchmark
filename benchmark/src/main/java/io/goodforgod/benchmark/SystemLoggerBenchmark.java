package io.goodforgod.benchmark;

import org.openjdk.jmh.annotations.*;

/**
 * Java System Logger benchmark
 *
 * @author Anton Kurako (GoodforGod)
 * @since 06.03.2022
 */
public abstract class SystemLoggerBenchmark extends LoggerBenchmark {

    protected SystemLoggerBenchmark() {}

    private System.Logger logger;
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
        logger = System.getLogger(LoggerBenchmark.class.getName());
    }

    @Benchmark
    public void messageOneArgumentInEnd() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {0}",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInEnd() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {0} and {1}",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInEnd() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with arguments {0} and {1} and {2}",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInStart() {
        logger.log(System.Logger.Level.INFO,
                "{0} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInStart() {
        logger.log(System.Logger.Level.INFO,
                "{0} and {1} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInStart() {
        logger.log(System.Logger.Level.INFO,
                "{0} and {1} and {2} arguments of this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInMiddle() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message with arguments {0} most developers use in their daily routing to represent most common scenarios",
                arg1);
    }

    @Benchmark
    public void messageTwoArgumentInMiddle() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message with arguments {0} and {1} most developers use in their daily routing to represent most common scenarios",
                arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInMiddle() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message with arguments {0} and {1} and {2} most developers use in their daily routing to represent most common scenarios",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageWithoutArguments() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios without arguments");
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.log(System.Logger.Level.INFO,
                "this long message is supposed to represent logging message most developers use in their daily routing to represent most common scenarios with stacktrace",
                exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Some unknown exception happen and have some stacktrace and message info");
    }
}
