# Java Logger Benchmark

[![GitHub Action](https://github.com/goodforgod/java-logger-benchmark/workflows/Java%20CI/badge.svg)](https://github.com/GoodforGod/java-logger-benchmark/actions?query=workflow%3A%22Java+CI%22)

JMH Benchmark for different Java Logger implementations.

Benchmark was initially created to test my [slf4j-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) implementation vs original [slf4j-simple-logger](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html).

## Benchmark

All loggers use synchronous output, **without any async appending mechanism**.

Benchmark consists of different common logging scenarios that developers typically use in their applications, by the name of the test you can understand what this situation try to emulate, here is full list of tests:
- messageAndStacktrace         
- messageWithoutArguments       
- messageOneArgumentInTheEnd    
- messageOneArgumentInTheMiddle  
- messageOneArgumentInTheStart   
- messageTwoArgumentInTheEnd    
- messageTwoArgumentInTheMiddle 
- messageTwoArgumentInTheStart 
- messageThreeArgumentInTheEnd
- messageThreeArgumentInTheMiddle
- messageThreeArgumentInTheStart

If you want to look at details, you can [check it here](https://github.com/GoodforGod/java-logger-benchmark/tree/master/benchmark/src/main/java/io/goodforgod/benchmark).

All loggers are configured to output to STDERR.

JMH precaution:
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
- OS: Ubuntu ([Github CI](https://github.com/GoodforGod/java-logger-benchmark/actions))
- Processor: Unknown
- Java: JDK 17.0.2, OpenJDK 64-Bit Server VM, 17.0.2+8-LTS
- [Execution](https://github.com/GoodforGod/java-logger-benchmark/blob/master/.github/workflows/gradle.yml#L37-L50): *java -jar benchmark-name.jar 2>/dev/null*

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

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

| Benchmark | Warmup | Runs | Units | goodforgod-simple | slf4j-simple | logback | log4j | java-system |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 58718±669 | 2684±142 | 54617±240 | 43765±605 | 22721±262 |
| messageWithoutArguments         | 2 | 6 | ops/s | 120257±34208 | 32231±4528 | 101818±5985 | 89485±12457 | 31956±747 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 116935±32015 | 43576±4416 | 93380±13191 | 87549±1835 | 29963±355 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 137995±36420 | 40252±9626 | 82164±3273 | 90059±17408 | 30299±167 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 100351±19414 | 41611±9423 | 88131±5613 | 92676±18736 | 30424±353 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 95318±4567 | 44082±4324 | 85102±3035 | 87795±7094 | 29248±548 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 101764±13604 | 41920±7623 | 86166±987 | 96163±28330 | 30086±642 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 97099±14191 | 48236±8364 | 91736±10191 | 85855±4260 | 29137±518 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 99141±11514 | 46913±3136 | 91344±8744 | 89784±14493 | 29543±371 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 96524±10997 | 38981±3724 | 90234±1231 | 89083±11264 | 30155±409 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 125277±10888 | 40526±13953 | 83704±1428 | 86095±2454 | 29521±311 |

### Setup 3

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

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


## Run

In case you want to try benchmark yourself, then you should compile and package all benchmarks first:
```shell
./gradlew shadowJar
```

Then you can run each of them in their proper directory, for example to run *goodforgod-simple-logger* benchmark:
```shell
java -jar goodforgod-simple-logger/build/libs/*all.jar
```

If you want to suppress logger output to measure raw performance, you should redirect STRERR that logger produce to /dev/null.
```shell
java -jar goodforgod-simple-logger/build/libs/*all.jar 2>/dev/null
```

### Configuration

You can configure the number of *warmup* and *iterations* with command line arguments, the first argument corresponds to warmups and second is for iterations:

Example below will run 1 warmup and 1 iteration:
```shell
java -jar goodforgod-simple-logger/build/libs/*all.jar 1 1
```