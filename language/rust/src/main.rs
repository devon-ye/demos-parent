
/*fn main() {
    let _x = 5;
    let _y=40;
    println!("Hello, world!");
}*/

use std::thread;

fn main() {
    let a= [1,5,3,4,6,7];


    search((&a).to_vec(),4);
    let new_thread = thread::spawn( move || {
        println!("I am a new thread");
    });

    new_thread.join().unwrap();

    println!("Recursive result: {}", recursive_factorial(10));
    println!("Iterative result: {}", iterative_factorial(10));
    println!("Iterator result: {}", iterator_factorial(10));
}

// 这个函数的if-else语句中展示了Rust中可选的隐式返回值，可用于写出更像函数式编程风格的代码
// 与C++和其他类似的语言不同，Rust中的if-else结构不是语句而是表达式，有返回值
fn recursive_factorial(n: u32) -> u32 {
    if n <= 1 {
        1
    } else {
        n * recursive_factorial(&n - 1)
    }
}


fn iterative_factorial(n: u32) -> u32 {
    // 变量用`let`定义，`mut`关键字使得变量可以变化
    let mut i = 1u32;
    let mut result = 1u32;
    while i <= n {
        result *= i;
        i += 1;
    }
    result // 显式返回值，与上一个函数不同
}


fn iterator_factorial(n: u32) -> u32 {
    // 迭代器有多种用于变换的函数
    // |accum, x| 定义了一个匿名函数
    // 内联展开等优化方法会消去区间和fold，使本函数的运行效率和上一个函数相近
    (1..n + 1).fold(1, |accum, x| accum * x)
}



