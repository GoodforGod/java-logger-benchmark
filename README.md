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

This benchmark results are based on run inside **GitHub CI** and **have forwarded stderr to /dev/null**.

Benchmark setup configuration:
- OS: Ubuntu (Github CI)
- Processor: Unknown
- Java: JDK 17.0.2, OpenJDK 64-Bit Server VM, 17.0.2+8-LTS
- Execution: *java -jar benchmark-name.jar 2>/dev/null*

| Benchmark | Warmup | Runs | Units | goodforgod-simple | slf4j-simple | logback | log4j | java-system |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 117365±2118 | 12832±1087 | 118095±2158 | 103683±3284 | 40342±629 |
| messageWithoutArguments         | 2 | 6 | ops/s | 503906±24217 | 176912±13586 | 488800±37822 | 420665±8805 | 40777±617 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 475680±23021 | 170384±29214 | 450336±4803 | 413645±32625 | 41513±823 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 476436±12130 | 190546±13642 | 454803±21936 | 429710±13751 | 41482±1392 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 460164±11014 | 186111±15280 | 444657±2332 | 417252±8034 | 40407±1313 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 449377±9286 | 178412±26319 | 440259±3819 | 371821±25846 | 40151±716 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 437624±4854 | 182567±17643 | 439746±12459 | 409443±10546 | 40756±690 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 433289±16436 | 181263±22115 | 433450±21592 | 387061±7459 | 40064±503 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 435443±14175 | 179582±21615 | 427762±34262 | 393146±8272 | 40407±1313 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 434948±25266 | 184036±20658 | 420698±32571 | 378362±15518 | 40150±681 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 441791±26952 | 183132±10275 | 422269±32483 | 398629±7963 | 39304±988 |

You can check [results by yourself](https://github.com/GoodforGod/java-logger-benchmark/actions/runs/1989473193).

### Setup 2

This benchmark **have forwarded stderr to NUL (/dev/null analog in windows)**.

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

| Benchmark | Warmup | Runs | Units | goodforgod-simple | slf4j-simple | logback | log4j | java-system |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s |  |  |  |  |  |
| messageWithoutArguments         | 2 | 6 | ops/s |  |  |  |  |  |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s |  |  |  |  |  |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s |  |  |  |  |  |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s |  |  |  |  |  |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s |  |  |  |  |  |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s |  |  |  |  |  |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s |  |  |  |  |  |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s |  |  |  |  |  |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s |  |  |  |  |  |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s |  |  |  |  |  |

### Setup 3

This benchmark **have forwarded stderr to NUL (/dev/null analog in windows)**.

Benchmark setup configuration:
- OS: Windows 10
- Processor: Intel i5-6200U
- Java: 
- Execution: *java -jar benchmark-name.jar 2>NUL*

| Benchmark | Warmup | Runs | Units | goodforgod-simple | slf4j-simple | logback | log4j | java-system |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 44741±1227 | 2074±166 | 30574±551 | 28409±718 | 15384±161 |
| messageWithoutArguments         | 2 | 6 | ops/s | 77648±2357 | 33142±4502 | 72632±2107 | 70858±4008 | 20126±5878 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 75533±4976 | 32307±12165 | 70459±1576 | 67934±3651 | 20420±693 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 75453±8568 | 31073±6345 | 71517±3054 | 65894±6387 | 20141±585 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 73486±15079 | 31229±7186 | 66942±2062 | 66961±1409 | 20163±276 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 75008±1818 | 32632±448 | 66768±4096 | 65697±1048 | 20421±265 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 75396±1473 | 30265±3249 | 69392±7265 | 68996±4110 | 20178±344 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 75785±2851 | 34428±996 | 68737±4562 | 67683±1720 | 20206±239 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 75579±4230 | 30621±5432 | 66103±2858 | 66542±2149 | 20232±371 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 74463±1725 | 30986±4792 | 69847±1797 | 66406±1474 | 20311±333 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 75444±1727 | 30203±4660 | 68149±3567 | 66786±1621 | 20280±315 |
