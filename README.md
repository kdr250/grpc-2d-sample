## 概要
Java gRPCの学習用レポジトリです。2Dバーチャルオフィスのようなツールを作ることを目指します。

## 起動方法
1. dockerを起動
```
// 初回
docker-compose up

// 2回目以降
docker-compose start
```
2. serverを起動
```
./gradlew :server:bootRun
```
3. clientを起動
```
./gradlew :client:bootRun
```

## 解説記事
[Qiita - JavaとgRPCで2Dバーチャルオフィスっぽい何かを作る ①概要編](https://qiita.com/kdr250/items/7a82ceaea3ae4a0ec917)
<br>
[Qiita - JavaとgRPCで2Dバーチャルオフィスっぽい何かを作る ②gRPC bidirectional streaming](https://qiita.com/kdr250/items/7eae0cfd31f24ccc0569)
