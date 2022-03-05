# SFL4J Benchmark

Template for Java [JVM](https://github.com/openjdk/jmh) benchmark.

## Benchmark

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

### Intel i5-6200U

#### slf4j-simple-logger
```text
Benchmark                               Mode  Cnt     Score   Error  Units
Bench.messageAndStacktrace             thrpt    2   200,864          ops/s
Bench.messageOneArgumentInTheEnd       thrpt    2  3869,573          ops/s
Bench.messageOneArgumentInTheMiddle    thrpt    2  4132,815          ops/s
Bench.messageOneArgumentInTheStart     thrpt    2  3969,714          ops/s
Bench.messageThreeArgumentInTheEnd     thrpt    2  3486,811          ops/s
Bench.messageThreeArgumentInTheMiddle  thrpt    2  3691,521          ops/s
Bench.messageThreeArgumentInTheStart   thrpt    2  3459,098          ops/s
Bench.messageTwoArgumentInTheEnd       thrpt    2  3654,998          ops/s
Bench.messageTwoArgumentInTheMiddle    thrpt    2  3879,683          ops/s
Bench.messageTwoArgumentInTheStart     thrpt    2  3829,707          ops/s
```

#### logback
```text

```

#### goodforgod-simple-logger
```text
Benchmark                               Mode  Cnt     Score   Error  Units
Bench.messageAndStacktrace             thrpt    2  1510,345          ops/s
Bench.messageOneArgumentInTheEnd       thrpt    2  8204,851          ops/s
Bench.messageOneArgumentInTheMiddle    thrpt    2  8345,315          ops/s
Bench.messageOneArgumentInTheStart     thrpt    2  8314,062          ops/s
Bench.messageThreeArgumentInTheEnd     thrpt    2  7819,210          ops/s
Bench.messageThreeArgumentInTheMiddle  thrpt    2  7890,785          ops/s
Bench.messageThreeArgumentInTheStart   thrpt    2  7744,189          ops/s
Bench.messageTwoArgumentInTheEnd       thrpt    2  8013,516          ops/s
Bench.messageTwoArgumentInTheMiddle    thrpt    2  8061,957          ops/s
Bench.messageTwoArgumentInTheStart     thrpt    2  7673,685          ops/s
```

### AMD Ryzen 2600X

#### slf4j-simple-logger
```text
Benchmark                               Mode  Cnt      Score   Error  Units
Bench.messageAndStacktrace             thrpt    2    953,764          ops/s
Bench.messageOneArgumentInTheEnd       thrpt    2  15764,729          ops/s
Bench.messageOneArgumentInTheMiddle    thrpt    2  16142,173          ops/s
Bench.messageOneArgumentInTheStart     thrpt    2  14409,350          ops/s
Bench.messageThreeArgumentInTheEnd     thrpt    2  14944,018          ops/s
Bench.messageThreeArgumentInTheMiddle  thrpt    2  15483,734          ops/s
Bench.messageThreeArgumentInTheStart   thrpt    2  14094,227          ops/s
Bench.messageTwoArgumentInTheEnd       thrpt    2  15308,267          ops/s
Bench.messageTwoArgumentInTheMiddle    thrpt    2  15285,620          ops/s
Bench.messageTwoArgumentInTheStart     thrpt    2  15712,520          ops/s
```

#### logback
```text
Benchmark                               Mode  Cnt      Score   Error  Units
Bench.messageAndStacktrace             thrpt    2   4639,948          ops/s
Bench.messageOneArgumentInTheEnd       thrpt    2  22624,605          ops/s
Bench.messageOneArgumentInTheMiddle    thrpt    2  22711,789          ops/s
Bench.messageOneArgumentInTheStart     thrpt    2  23478,570          ops/s
Bench.messageThreeArgumentInTheEnd     thrpt    2  21440,504          ops/s
Bench.messageThreeArgumentInTheMiddle  thrpt    2  21595,183          ops/s
Bench.messageThreeArgumentInTheStart   thrpt    2  21723,252          ops/s
Bench.messageTwoArgumentInTheEnd       thrpt    2  22036,067          ops/s
Bench.messageTwoArgumentInTheMiddle    thrpt    2  22696,342          ops/s
Bench.messageTwoArgumentInTheStart     thrpt    2  22352,155          ops/s
```

#### goodforgod-simple-logger
```text
Benchmark                               Mode  Cnt      Score   Error  Units
Bench.messageAndStacktrace             thrpt    2   4793,825          ops/s
Bench.messageOneArgumentInTheEnd       thrpt    2  26834,758          ops/s
Bench.messageOneArgumentInTheMiddle    thrpt    2  25032,819          ops/s
Bench.messageOneArgumentInTheStart     thrpt    2  26771,454          ops/s
Bench.messageThreeArgumentInTheEnd     thrpt    2  25662,535          ops/s
Bench.messageThreeArgumentInTheMiddle  thrpt    2  23354,374          ops/s
Bench.messageThreeArgumentInTheStart   thrpt    2  25507,755          ops/s
Bench.messageTwoArgumentInTheEnd       thrpt    2  25556,091          ops/s
Bench.messageTwoArgumentInTheMiddle    thrpt    2  23556,434          ops/s
Bench.messageTwoArgumentInTheStart     thrpt    2  26413,955          ops/s
```
