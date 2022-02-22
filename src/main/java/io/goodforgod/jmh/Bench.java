package io.goodforgod.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class Bench {

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(Bench.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();
    }

    private String argument;

    @Setup
    public void setup() {
        argument = "SimpleVariable";
    }

    @Benchmark
    public void bench() {
        System.out.println(argument);
    }
}
