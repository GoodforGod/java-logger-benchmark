package io.goodforgod.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoggerBenchmark {

    protected LoggerBenchmark() {}

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

    protected static Options getBenchmarkOptions(Class<?> benchType) {
        return new OptionsBuilder()
                .include(benchType.getSimpleName())
                .forks(1)
                .mode(Mode.Throughput)
                .measurementIterations(2)
                .warmupIterations(1)
                .build();
    }

    @Benchmark
    public void messageOneArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with the argument: {}", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with arguments '{}' and '{}'", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheEnd() {
        logger.debug("Message is printed for this logger and with arguments '{}' and '{}' and '{}'", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheStart() {
        logger.debug("'{}' argument and message is printed for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheStart() {
        logger.debug("'{}' and '{}' arguments and message is printed for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheStart() {
        logger.debug("'{}' and '{}' and '{}' argument and message is printed for this logger", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageOneArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' argument for this logger", arg1);
    }

    @Benchmark
    public void messageTwoArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' and '{}' argument for this logger", arg1, arg2);
    }

    @Benchmark
    public void messageThreeArgumentInTheMiddle() {
        logger.debug("Message is printed for '{}' and '{}' and '{}' argument for this logger", arg1, arg2, arg3);
    }

    @Benchmark
    public void messageAndStacktrace() {
        logger.warn("Message is printed for this logger and there is stacktrace", exception);
    }

    // cause we need stacktrace
    private void throwEx() throws Exception {
        throw new Exception("Some unknown exception happen and have some stacktrace and message info");
    }
}
