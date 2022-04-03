# Java Logger Benchmark

[![GitHub Action](https://github.com/goodforgod/java-logger-benchmark/workflows/Java%20CI/badge.svg)](https://github.com/GoodforGod/java-logger-benchmark/actions?query=workflow%3A%22Java+CI%22)

JMH Benchmark for different Java Logger implementations.

Idea behind this benchmark is to put all loggers in the same conditions and measure 
how they all handle the most common scenarios developers use and compare their implementation in such scenarios. 
At the end it is your choice to make, do you want performance or flexibility some loggers provide and what are trade-offs.

## Loggers

Benchmark features these loggers:
- [io.goodforgod:slf4j-simple-logger:0.13.0](https://github.com/GoodforGod/slf4j-simple-logger)
- [org.slf4j:slf4j-simple:1.7.36](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html)
- [ch.qos.logback:logback-classic:1.2.11](https://logback.qos.ch/)
- [org.apache.logging.log4j:log4j-core:2.17.2](https://logging.apache.org/log4j/2.x/index.html)
- [System.Logger](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) (Java 17)


## Benchmark

All loggers use synchronous output, **without any async appending mechanism**.
All loggers are configured to output to *STDERR* on purpose.
All loggers are configured to use identical output layout.

Pseudo output layout for all loggers:
`{date} [{level}] {logger} - {message}{separator}{stacktrace}`

Description of output layout:
- *{date}* - logging message datetime (uses formatter `yyyy-MM-dd'T'HH:mm:ss.SSS`)
- *{level}* - logging level
- *{logger}* - logger full class name
- *{message}* - logging message content
- *{separator}* - new line to separate logging messages
- *{stacktrace}* - exception stacktrace if present

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

Here are corresponding examples of resulted log messages (excluding *messageAndStacktrace* due to big stacktrace):
```text
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for this logger without arguments
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for this logger and with the argument: FirstArgument
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for FirstArgument argument for this logger
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - FirstArgument argument and message is printed for this logger
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for this logger and with arguments FirstArgument and SecondArgument
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for FirstArgument and SecondArgument argument for this logger
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - FirstArgument and SecondArgument arguments and message is printed for this logger
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for this logger and with arguments FirstArgument and SecondArgument and ThirdArgument
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - Message is printed for FirstArgument and SecondArgument and ThirdArgument argument for this logger
2022-03-22T15:33:48.723 [INFO] io.goodforgod.benchmark.LoggerBenchmark - FirstArgument and SecondArgument and ThirdArgument argument and message is printed for this logger
```

If you want to look at benchmark details, you can [check it here](https://github.com/GoodforGod/java-logger-benchmark/tree/master/benchmark/src/main/java/io/goodforgod/benchmark).

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

| Benchmark | Warmup | Runs | Units | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 118216±813 | 115822±428 | 104783±501 | 13338±223 | 40445±203 |
| messageWithoutArguments         | 2 | 6 | ops/s | 499217±1199 | 473321±5493 | 417106±6782 | 175836±1835 | 43540±467 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 458897±4559 | 443582±2258 | 400907±5836 | 169457±3192 | 40692±811 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 473144±13985 | 451131±15834 | 422485±5795 | 173946±1803 | 40464±552 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 460671±4028 | 432312±2706 | 406973±6916 | 173542±2095 | 41138±587 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 452458±6389 | 444213±3966 | 397294±7014 | 164550±3379 | 40661±531 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 432949±5454 | 442847±5500 | 390417±3958 | 168683±1862 | 41380±403 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 448363±4246 | 440998±4881 | 392745±10002 | 167334±2699 | 39528±231 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 423541±3972 | 426526±5837 | 396242±8698 | 169260±1842 | 40128±464 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 430087±2801 | 409115±3378 | 392355±5064 | 167569±9936 | 40184±244 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 425695±2946 | 422243±7029 | 373625±6822 | 168490±848 | 39986±586 |

You can validate [results yourself](https://github.com/GoodforGod/java-logger-benchmark/actions/runs/2004818675).

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
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


If we shrink results even more and compute average for all messages with arguments as single result then:

| Benchmark              | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
| ---------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| message and stacktrace | 100               | 98.0    | 88.6  | 11.3         | 34.2        |
| message with arguments | 100               | 97.5    | 88.7  | 37.8         | 9.1         |

### Setup 2

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

Benchmark setup configuration:
- OS: Windows 10
- Processor: AMD Ryzen 2600X
- Java: OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

#### Raw Results

| Benchmark | Warmup | Runs | Units | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 58718±669 | 54617±240 | 43765±605 | 2684±142 | 22721±262 |
| messageWithoutArguments         | 2 | 6 | ops/s | 120257±34208 | 101818±5985 | 89485±12457 | 32231±4528 | 31956±747 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 116935±32015 | 93380±13191 | 87549±1835 | 43576±4416 | 29963±355 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 137995±36420 | 82164±3273 | 90059±17408 | 40252±9626 | 30299±167 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 100351±19414 | 88131±5613 | 92676±18736 | 41611±9423 | 30424±353 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 95318±4567 | 85102±3035 | 87795±7094 | 44082±4324| 29248±548 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 101764±13604 | 86166±987 | 96163±28330 | 41920±7623 | 30086±642 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 97099±14191 | 91736±10191 | 85855±4260 | 48236±8364 | 29137±518 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 99141±11514 | 91344±8744 | 89784±14493 | 46913±3136 | 29543±371 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 96524±10997 | 90234±1231 | 89083±11264 | 38981±3724 | 30155±409 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 125277±10888 | 83704±1428 | 86095±2454 | 40526±13953 | 29521±311 |

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
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


If we shrink results even more and compute average for all messages with arguments as single result then:

| Benchmark              | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
| ---------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| message and stacktrace | 100               | 93.0    | 74.5  | 4.6          | 38.7        |
| message with arguments | 100               | 83.3    | 83.3  | 39.2         | 27.9        |

### Setup 3

This benchmark **have forwarded stderr to NUL** *(/dev/null analog in windows)*

Benchmark setup configuration:
- OS: Windows 10
- Processor: Intel i5-6200U
- Java: OpenJDK 64-Bit Server VM (build 17.0.1+12-39, mixed mode, sharing)
- Execution: *java -jar benchmark-name.jar 2>NUL*

#### Raw Results

| Benchmark | Warmup | Runs | Units | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
|---|---|---|---|---|---|---|---|---|
| messageAndStacktrace            | 2 | 6 | ops/s | 44741±1227 | 30574±551 | 28409±718 | 2074±166 | 15384±161 |
| messageWithoutArguments         | 2 | 6 | ops/s | 77648±2357 | 72632±2107 | 70858±4008 | 33142±4502 | 20126±5878 |
| messageOneArgumentInTheEnd      | 2 | 6 | ops/s | 75533±4976 | 70459±1576 | 67934±3651 | 32307±12165 | 20420±693 |
| messageOneArgumentInTheMiddle   | 2 | 6 | ops/s | 75453±8568 | 71517±3054 | 65894±6387 | 31073±6345 | 20141±585 |
| messageOneArgumentInTheStart    | 2 | 6 | ops/s | 73486±15079 | 66942±2062 | 66961±1409 | 31229±7186 | 20163±276 |
| messageTwoArgumentInTheEnd      | 2 | 6 | ops/s | 75008±1818 | 66768±4096 | 65697±1048 | 32632±448 | 20421±265 |
| messageTwoArgumentInTheMiddle   | 2 | 6 | ops/s | 75396±1473 | 69392±7265 | 68996±4110 | 30265±3249 | 20178±344 |
| messageTwoArgumentInTheStart    | 2 | 6 | ops/s | 75785±2851 | 68737±4562 | 67683±1720 | 34428±996 | 20206±239 |
| messageThreeArgumentInTheEnd    | 2 | 6 | ops/s | 75579±4230 | 66103±2858 | 66542±2149 | 30621±5432 | 20232±371 |
| messageThreeArgumentInTheMiddle | 2 | 6 | ops/s | 74463±1725 | 69847±1797 | 66406±1474 | 30986±4792 | 20311±333 |
| messageThreeArgumentInTheStart  | 2 | 6 | ops/s | 75444±1727 | 68149±3567 | 66786±1621 | 30203±4660 | 20280±315 |

#### Processed Results

If we take [goodforgod-simple-logger](https://github.com/GoodforGod/slf4j-simple-logger) as baseline and compute other loggers performance based on numbers above:

| Benchmark                       | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
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


If we shrink results even more and compute average for all messages with arguments as single result then:

| Benchmark              | [goodforgod-simple](https://github.com/GoodforGod/slf4j-simple-logger) | [logback](https://logback.qos.ch/) | [log4j](https://logging.apache.org/log4j/2.x/index.html) | [slf4j-simple](https://www.slf4j.org/api/org/slf4j/impl/SimpleLogger.html) | [java-system](https://docs.oracle.com/javase/9/docs/api/java/lang/System.Logger.html) |
| ---------------------- | ----------------- | ------- | ----- | ------------ | ----------- |
| message and stacktrace | 100               | 68.3    | 63.5  | 4.6          | 34.4        |
| message with arguments | 100               | 91.6    | 89.4  | 42.0         | 26.9        |

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

You can configure the number of *warmup*, *iterations* and *threads* with command line arguments:
- First argument is for warmups.
- Second is for iterations.
- Third is for threads.

Example below will run 1 warmup and 2 iteration and 3 threads:
```shell
java -jar goodforgod-simple-logger/build/libs/*all.jar 1 2 3
```