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

#### Raw Results

| Benchmark | Warmup | Runs | Units | goodforgod-simple | slf4j-simple | logback | log4j | java-system |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 118216±813 | 13338±223 | 115822±428 | 104783±501 | 40445±203 |
| messageWithoutArguments         | 2 | 6 | ops/s | 499217±1199 | 175836±1835 | 473321±5493 | 417106±6782 | 43540±467 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 458897±4559 | 169457±3192 | 443582±2258 | 400907±5836 | 40692±811 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 473144±13985 | 173946±1803 | 451131±15834 | 422485±5795 | 40464±552 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 460671±4028 | 173542±2095 | 432312±2706 | 406973±6916 | 41138±587 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 452458±6389 | 164550±3379 | 444213±3966 | 397294±7014 | 40661±531 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 432949±5454 | 168683±1862 | 442847±5500 | 390417±3958 | 41380±403 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 448363±4246 | 167334±2699 | 440998±4881 | 392745±10002 | 39528±231 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 423541±3972 | 169260±1842 | 426526±5837 | 396242±8698 | 40128±464 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 430087±2801 | 167569±9936 | 409115±3378 | 392355±5064 | 40184±244 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 425695±2946 | 168490±848 | 422243±7029 | 373625±6822 | 39986±586 |

You can validate [results yourself](https://github.com/GoodforGod/java-logger-benchmark/actions/runs/2004818675).

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | goodforgod-simple | logback | log4j | slf4j-simple | java-system |
| ------------------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| messageAndStacktrace            | 100               | 98.0    | 88.6  | 11.3         | 34.2        |
| messageWithoutArguments         | 100               | 94.8    | 83.6  | 35.2         | 8.7         |
| messageOneArgumentInTheEnd      | 100               | 96.7    | 87.4  | 36.9         | 8.9         |
| messageOneArgumentInTheMiddle   | 100               | 95.3    | 89.3  | 36.8         | 8.6         |
| messageOneArgumentInTheStart    | 100               | 93.8    | 88.3  | 37.7         | 8.9         |
| messageTwoArgumentInTheEnd      | 100               | 98.2    | 87.8  | 36.4         | 9.0         |
| messageTwoArgumentInTheMiddle   | 100               | 102.3   | 90.2  | 39.0         | 9.6         |
| messageTwoArgumentInTheStart    | 100               | 98.4    | 87.6  | 37.3         | 8.8         |
| messageThreeArgumentInTheEnd    | 100               | 100.7   | 93.6  | 40.0         | 9.5         |
| messageThreeArgumentInTheMiddle | 100               | 95.1    | 91.2  | 39.0         | 9.3         |
| messageThreeArgumentInTheStart  | 100               | 99.2    | 87.8  | 39.6         | 9.4         |

### Setup 2

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*
- 
#### Raw Results

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

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | goodforgod-simple | logback | log4j | slf4j-simple | java-system |
| ------------------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| messageAndStacktrace            | 100               | 93.0    | 74.5  | 4.6          | 38.7        |
| messageWithoutArguments         | 100               | 84.7    | 74.4  | 26.8         | 26.6        |
| messageOneArgumentInTheEnd      | 100               | 79.9    | 74.9  | 37.3         | 25.6        |
| messageOneArgumentInTheMiddle   | 100               | 59.5    | 65.3  | 29.2         | 22.0        |
| messageOneArgumentInTheStart    | 100               | 87.8    | 92.4  | 41.5         | 30.3        |
| messageTwoArgumentInTheEnd      | 100               | 89.3    | 92.1  | 46.2         | 30.7        |
| messageTwoArgumentInTheMiddle   | 100               | 84.7    | 94.5  | 41.2         | 29.6        |
| messageTwoArgumentInTheStart    | 100               | 94.5    | 88.4  | 49.7         | 30.0        |
| messageThreeArgumentInTheEnd    | 100               | 92.1    | 90.6  | 47.3         | 29.8        |
| messageThreeArgumentInTheMiddle | 100               | 93.5    | 92.3  | 40.4         | 31.2        |
| messageThreeArgumentInTheStart  | 100               | 66.8    | 68.7  | 32.3         | 23.6        |

### Setup 3

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

Benchmark setup configuration:
- OS: Windows 10
- Processor: Intel i5-6200U
- Java: OpenJDK 64-Bit Server VM (build 17.0.1+12-39, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

#### Raw Results

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

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | goodforgod-simple | logback | log4j | slf4j-simple | java-system |
| ------------------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| messageAndStacktrace            | 100               | 68.3    | 63.5  | 4.6          | 34.4        |
| messageWithoutArguments         | 100               | 93.5    | 91.3  | 42.7         | 25.9        |
| messageOneArgumentInTheEnd      | 100               | 93.3    | 89.9  | 42.8         | 27.0        |
| messageOneArgumentInTheMiddle   | 100               | 94.8    | 87.3  | 41.2         | 26.7        |
| messageOneArgumentInTheStart    | 100               | 91.1    | 91.1  | 42.5         | 27.4        |
| messageTwoArgumentInTheEnd      | 100               | 89.0    | 87.6  | 43.5         | 27.2        |
| messageTwoArgumentInTheMiddle   | 100               | 92.0    | 91.5  | 40.1         | 26.8        |
| messageTwoArgumentInTheStart    | 100               | 90.7    | 89.3  | 45.4         | 26.7        |
| messageThreeArgumentInTheEnd    | 100               | 87.5    | 88.0  | 40.5         | 26.8        |
| messageThreeArgumentInTheMiddle | 100               | 93.8    | 89.2  | 41.6         | 27.3        |
| messageThreeArgumentInTheStart  | 100               | 90.3    | 88.5  | 40.0         | 26.9        |

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