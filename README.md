# Java Logger Benchmark

JMH Benchmark for multiple Java Logger implementations.

## Benchmark

All loggers use synchronous output, **without any async appending mechanism**.

JMH benchmark information:
```text
REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.
```

### Setup 1

This benchmark results are based on run inside **GitHub CI** and **have forwarded stdout to /dev/null**, due to such reasons numbers differ a lot from other setups.

Benchmark setup configuration:
- OS: Ubuntu (Github CI)
- Processor: Unknown
- Java: 17
- Execution: *java -jar benchmark-name.jar 2>/dev/null*

| Benchmark | Mode | Warmup | Iterations | Units | goodforgod-simple | slf4j-simple | logback | java-system | log4j |
|---|---|---|---|---|---|---|---|---|---|
| Bench.messageAndStacktrace            | thrpt | 2 | 6 | ops/s | 108969.841 ±  1220.438 | 12366.305 ±  461.561  | 111496.173 ±  4041.352 | 37387.085 ± 2245.224 | 87795.288 ±  1983.474 |
| Bench.messageWithoutArguments         | thrpt | 2 | 6 | ops/s | 358553.097 ±  5158.998 | 151473.706 ± 4238.530 | 415666.850 ± 13100.520 | 37755.863 ±  842.232 | 396755.873 ± 10690.119 |
| Bench.messageOneArgumentInTheEnd      | thrpt | 2 | 6 | ops/s | 349349.389 ± 13009.057 | 148200.910 ± 2213.046 | 393199.681 ±  9640.942 | 37061.470 ±  477.426 | 382316.724 ±  8532.265 |
| Bench.messageOneArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s | 338682.012 ± 19501.442 | 157137.503 ± 3342.646 | 404744.761 ± 12918.572 | 37221.650 ±  818.886 | 377354.507 ±  7989.285 |
| Bench.messageOneArgumentInTheStart    | thrpt | 2 | 6 | ops/s | 337172.005 ± 12300.264 | 153211.637 ± 1223.746 | 411442.696 ± 12080.951 | 36818.120 ±  686.588 | 375460.958 ± 15183.787 |
| Bench.messageTwoArgumentInTheEnd      | thrpt | 2 | 6 | ops/s | 343983.274 ± 12776.517 | 146449.651 ± 2212.247 | 369039.069 ± 12823.837 | 36728.274 ±  696.379 | 361242.660 ± 10655.840 |
| Bench.messageTwoArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s | 333923.221 ±  6596.461 | 145630.924 ± 2384.116 | 392314.282 ±  5199.286 | 36565.767 ±  616.770 | 374722.478 ± 10728.525 |
| Bench.messageTwoArgumentInTheStart    | thrpt | 2 | 6 | ops/s | 336758.535 ±  7078.576 | 151427.439 ± 2504.679 | 401265.411 ± 11911.763 | 36682.291 ± 1096.114 | 372485.611 ±  6252.810 |
| Bench.messageThreeArgumentInTheEnd    | thrpt | 2 | 6 | ops/s | 322653.951 ±  8691.489 | 147825.295 ± 2136.851 | 385971.999 ± 10836.915 | 35154.545 ±  551.951 | 348492.960 ±  2281.462 |
| Bench.messageThreeArgumentInTheMiddle | thrpt | 2 | 6 | ops/s | 332297.514 ± 16354.319 | 146118.604 ± 2632.893 | 382905.102 ±  6866.816 | 34867.715 ±  603.432 | 367751.281 ±  5236.246 |
| Bench.messageThreeArgumentInTheStart  | thrpt | 2 | 6 | ops/s | 321365.354 ±  4217.673 | 146939.607 ± 3065.354 | 386608.630 ±  9976.115 | 35927.525 ± 1518.802 | 355676.256 ±  9404.628 |

You can check [results by yourself](https://github.com/GoodforGod/java-logger-benchmark/runs/5526628089).

### Setup 2

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

| Benchmark | Mode | Warmup | Iterations | Units | goodforgod-simple | slf4j-simple | logback | java-system | log4j |
|---|---|---|---|---|---|---|---|---|---|
| Bench.messageAndStacktrace            | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageWithoutArguments         | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheEnd      | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheStart    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheEnd      | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheStart    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheEnd    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheMiddle | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheStart  | thrpt | 2 | 6 | ops/s |  |  |  |  |  |

### Setup 3

Benchmark setup configuration:
- OS: Windows 10
- Processor: Intel i5-6200U
- Java: 
- Execution: *java -jar benchmark-name.jar 2>NUL*

| Benchmark | Mode | Warmup | Iterations | Units | goodforgod-simple | slf4j-simple | logback | java-system | log4j |
|---|---|---|---|---|---|---|---|---|---|
| Bench.messageAndStacktrace            | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageWithoutArguments         | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheEnd      | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageOneArgumentInTheStart    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheEnd      | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheMiddle   | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageTwoArgumentInTheStart    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheEnd    | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheMiddle | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
| Bench.messageThreeArgumentInTheStart  | thrpt | 2 | 6 | ops/s |  |  |  |  |  |
