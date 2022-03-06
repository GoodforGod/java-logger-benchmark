package io.goodforgod.systemlogger;

import io.goodforgod.benchmark.SystemLoggerBenchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
public class Bench extends SystemLoggerBenchmark {

    public static void main(String[] args) throws RunnerException {
        new Runner(getBenchmarkOptions(Bench.class)).run();
    }
}
