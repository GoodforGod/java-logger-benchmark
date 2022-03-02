# SFL4J Benchmark

Template for Java [JVM](https://github.com/openjdk/jmh) benchmark.

## Benchmark

### Intel(R) Core(TM) i5-6200U

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
