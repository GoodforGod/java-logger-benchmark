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

    protected static Runner getBenchmarkRunner(Class<?> benchType, String[] args) {
        return new Runner(getBenchmarkOptions(benchType, args));
    }

    protected static Options getBenchmarkOptions(Class<?> benchType, String[] args) {
        final int warmup = getNumberOfWarmup(args);
        final int iterations = getNumberOfIterations(args);
        final int threads = getNumberOfThreads(args);

        System.out.println("Number of Warmup: " + warmup + ", Iterations: " + iterations + ", Threads: " + threads);

        return new OptionsBuilder()
                .include(benchType.getSimpleName())
                .forks(1)
                .mode(Mode.Throughput)
                .measurementIterations(iterations)
                .warmupIterations(warmup)
                .threads(threads)
                .build();
    }

    private static int getNumberOfWarmup(String[] args) {
        return args.length > 0
                ? Integer.parseInt(args[0])
                : 2;
    }

    private static int getNumberOfIterations(String[] args) {
        return args.length > 1
                ? Integer.parseInt(args[1])
                : 6;
    }

    private static int getNumberOfThreads(String[] args) {
        return args.length > 2
                ? Integer.parseInt(args[2])
                : 1;
    }
}
