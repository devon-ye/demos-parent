# Rust


## 关键词

### 变量
  * let 
        
        声明不可变变量
  * mut 
    
        变量可变修饰符
        
### 函数fn

```rust

fn fn_name(paramter1:type1,parameter2:type2) -> returnType{
   
}


```


## 数据类型

- 有符号
    
    i8、i16、i32、i64、i128 isize
- 无符号

    u8、u16u32、u64、u128、usize
- 浮点
    f32、f64
- 字符
    char
- 布尔
    bool 
- 元组
   Tuple()
       
       例如：    let tuple = (1, "hello", 4.5, true);
- 数组
   Arrays
   
        例如：    let xs: [i32; 5] = [1, 2, 3, 4, 5];

- 切片
   Slices
    
        例如：
- 结构体
    struct
    
        例如：   
```rust
     // A unit struct
        struct Nil;

    // A tuple struct
    struct Pair(i32, f32);

    // A struct with two fields
    struct Point {
        x: f32,
        y: f32,
    }
```
- 枚举
``` RUST
    enum typeN{
        // An `enum` may either be `unit-like`,
        PageLoad,
        PageUnload,
        // like tuple structs,
        KeyPress(char),
        Paste(String),
        // or c-like structures.
        Click { x: i64, y: i64 },
    }
```
- 常量

    static LANGUAGE: &str = "Rust";
    
    const THRESHOLD: i32 = 10;

## 流程控制

## 特征

### 所有权（owner-ship）

* 规则
    
        rust中的每个值都有一个变量、称其为所有者
        一次只能有一个所有者
        当所有者超出范围时，该值将被删除

## 适用场景