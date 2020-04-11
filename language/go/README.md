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

### 代码结构

Go工程中共有三个文件夹，分别是:src、pkg、bin。

1.  src：存放go源码文件
2.  pkg：存放编译后的包文件
3.  bin：存放编译后的可执行文件
4.  src目录需要手动创建，一般pkg和bin目录不需要创建，编译时会自动创建。

### package
1.  生成可执行程序main包下必须有main函数

### import

* 小括号导入包

```go
package package_name

import (
    "fmt"  
    "path"
   .  "fmt"  //  直接省略包路径调用函数
  alias "io"   //复杂包路径简化
  _   "strings"  //仅导入该包中的init函数
)

func funcName(){  fmt.Println(  "hello, go import ")}

```

* 分行导入包
```go
package package_name
import "fmt"
import "path"

func funcName(){  fmt.Println(  "hello, go import ")}
```
* import 原理

       
          如果一个main导入其他包，包将被顺序导入
          如果导入的包中以来其他包（包B），会首先导入B包，然后初始化B包中的常量与变量，最后如果B中有init，会自动执行initial（）；
          所有包到入完成之后才会对main中常量和变量进行初始化，然后执行main中的init函数（如果存在），最后执行main函数；


### func(函数)
```go
func functionName(parameterName1 type1,parameterName2 type2)(output1 type1,output2 type2){
	// bussine logic
	output1 := 5
	output2 := output1 * 5
	
	return output1,output2
}

```

## 数据类型


int8 ===1

int32 === 4

int64 ===8

占用内存数


## 变量

* 局部变量

* 全局变量

* 变量的可见性规则

        大写字母开头的变量是可导出的，也就是其它包可以读取的，是公用变量；

        小写字母开头的就是不可导出的，是私有变量