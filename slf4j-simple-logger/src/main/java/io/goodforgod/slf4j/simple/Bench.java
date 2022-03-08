package io.goodforgod.slf4j.simple;

import io.goodforgod.benchmark.Slf4jLoggerBenchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
public class Bench extends Slf4jLoggerBenchmark {

    public static void main(String[] args) throws RunnerException {
        getBenchmarkRunner(Bench.class).run();
    }
}
