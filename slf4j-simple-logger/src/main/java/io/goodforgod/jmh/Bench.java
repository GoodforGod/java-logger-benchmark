package io.goodforgod.jmh;

import io.goodforgod.benchmark.LoggerBenchmark;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;

@State(Scope.Benchmark)
public class Bench extends LoggerBenchmark {

    public static void main(String[] args) throws RunnerException {
        new Runner(getBenchmarkOptions(Bench.class)).run();
    }
}
