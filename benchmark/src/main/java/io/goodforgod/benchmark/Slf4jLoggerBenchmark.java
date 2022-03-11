package io.goodforgod.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sfl4j benchmark
 *
 * @author Anton Kurako (GoodforGod)
 * @since 03.03.2022
 */
public abstract class Slf4jLoggerBenchmark extends LoggerBenchmark {

    protected Slf4jLoggerBenchmark() {}

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
        logger = LoggerFactory.getLogger(LoggerBenchmark.class);
    }

    @Benchmark
    public void messageOneArgumentInTheEnd() {
        logger.info("Message is printed for this logger and with the argument: {}", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheEnd() {
        logger.info("Message is printed for this logger and with arguments {} and {}", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheEnd() {
        logger.info("Message is printed for this logger and with arguments {} and {} and {}", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheStart() {
        logger.info("{} argument and message is printed for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheStart() {
        logger.info("{} and {} arguments and message is printed for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheStart() {
        logger.info("{} and {} and {} argument and message is printed for this logger", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheMiddle() {
        logger.info("Message is printed for {} argument for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheMiddle() {
        logger.info("Message is printed for {} and {} argument for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheMiddle() {
        logger.info("Message is printed for {} and {} and {} argument for this logger", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageWithoutArguments() {
        logger.info("Message is printed for this logger without arguments");
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.info("Message is printed for this logger and there is stacktrace", exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Some unknown exception happen and have some stacktrace and message info");
    }
}
