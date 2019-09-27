# Golang



## 特点

1.  开发高效、部署简单、运行效率高
2.  语言层面支持并发、易于用多核实现并发
3.  内置runtime（性能监控、GC）

## 应用场景

1.  网络编程  
2.  服务器编程   
3.  分布式系统
4.  云平台




## 基础语法

* 代码结构

Go工程中共有三个文件夹，分别是:src、pkg、bin。

1.  src：存放go源码文件
2.  pkg：存放编译后的包文件
3.  bin：存放编译后的可执行文件
4.  src目录需要手动创建，一般pkg和bin目录不需要创建，编译时会自动创建。

* package
1.  生成可执行程序main包下必须有main函数

* import

小括号导入包

```go
package package_name

import (
    "fmt"
    "path"
)

func funcName(){  fmt.Println(  "hello, go import ")}







```

分行导入包
```go
package package_name
import "fmt"
import "path"

func funcName(){  fmt.Println(  "hello, go import ")}
```
