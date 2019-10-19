package main

import (
	"fmt"
	"runtime"
)

func currency() string {
	c := make(chan string)
	fmt.Println("doing concurrency execute")
	c <- "这是channnel读入的文本信息！"
	return ""
}

func main() {
	runtime.GOMAXPROCS(runtime.NumCPU())

	go currency()

	numCPU := runtime.NumCPU()
	fmt.Println(numCPU)

	fmt.Println("cpu nums:" + string(runtime.NumCPU()))
}
