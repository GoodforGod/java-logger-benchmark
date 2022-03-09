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
    public void messageOneArgumentInTheEnd() {
        logger.log(System.Logger.Level.INFO, "Message is printed for this logger and with the argument: {0}", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheEnd() {
        logger.log(System.Logger.Level.INFO, "Message is printed for this logger and with arguments {0} and {1}", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheEnd() {
        logger.log(System.Logger.Level.INFO, "Message is printed for this logger and with arguments {0} and {1} and {2}",
                arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheStart() {
        logger.log(System.Logger.Level.INFO, "{0} argument and message is printed for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheStart() {
        logger.log(System.Logger.Level.INFO, "{0} and {1} arguments and message is printed for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheStart() {
        logger.log(System.Logger.Level.INFO, "{0} and {1} and {2} argument and message is printed for this logger", arg1,
                arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheMiddle() {
        logger.log(System.Logger.Level.INFO, "Message is printed for {0} argument for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheMiddle() {
        logger.log(System.Logger.Level.INFO, "Message is printed for {0} and {1} argument for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheMiddle() {
        logger.log(System.Logger.Level.INFO, "Message is printed for {0} and {1} and {2} argument for this logger", arg1,
                arg2, arg3);
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.log(System.Logger.Level.INFO, "Message is printed for this logger and there is stacktrace", exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Some unknown exception happen and have some stacktrace and message info");
    }
}
