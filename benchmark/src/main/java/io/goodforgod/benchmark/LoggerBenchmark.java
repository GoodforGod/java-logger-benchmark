package io.goodforgod.benchmark;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 08.03.2022
 */
abstract class LoggerBenchmark {

    LoggerBenchmark() {}

    protected static Runner getBenchmarkRunner(Class<?> benchType) {
        return new Runner(getBenchmarkOptions(benchType));
    }

    protected static Options getBenchmarkOptions(Class<?> benchType) {
        return new OptionsBuilder()
                .include(benchType.getSimpleName())
                .forks(1)
                .mode(Mode.Throughput)
                .measurementIterations(6)
                .warmupIterations(2)
                .build();
    }
}
