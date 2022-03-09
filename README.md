# Java Logger Benchmark

JMH Benchmark for multiple Java Logger implementations.

## Benchmark

JMH benchmark information:
```text
REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.
```

### Setup 1

Benchmark setup configuration:
- OS: Windows 10
- Processor: Intel i5-6200U
- Java: 
- Execution: Command prompt -> java -jar benchmark-name.jar

| Benchmark | Mode | Cnt | Units | slf4j-simple-logger | logback | system-logger | goodforgod-simple-logger |
|---|---|---|---|---|---|---|---|
| Bench.messageAndStacktrace            | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheEnd      | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheMiddle   | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheStart    | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheEnd    | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheMiddle | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheStart  | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheEnd      | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheMiddle   | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheStart    | thrpt | 5 | ops/s |  |  |  |  |

### Setup 2

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: Command prompt -> java -jar benchmark-name.jar

| Benchmark | Mode | Cnt | Units | slf4j-simple-logger | logback | system-logger | goodforgod-simple-logger |
|---|---|---|---|---|---|---|---|
| Bench.messageAndStacktrace            | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheEnd      | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheMiddle   | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageOneArgumentInTheStart    | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheEnd    | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheMiddle | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageThreeArgumentInTheStart  | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheEnd      | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheMiddle   | thrpt | 5 | ops/s |  |  |  |  |
| Bench.messageTwoArgumentInTheStart    | thrpt | 5 | ops/s |  |  |  |  |
