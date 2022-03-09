package io.goodforgod.log4j;

import io.goodforgod.benchmark.Log4jLoggerBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
public class Bench extends Log4jLoggerBenchmark {

    public static void main(String[] args) throws RunnerException {
        getBenchmarkRunner(Bench.class).run();
    }
}
