use std::thread;
use std::string::ToString;

fn main() {

    let new_thread = thread::spawn( move || {
        println!("I am a new thread");
    });

     new_thread.join().unspaw();



    // 创建一个线程，线程名称为 thread1, 堆栈大小为4k
    let new_thread_result = thread::Builder::new()
        .name("thread1".to_string())
        .stack_size(4*1024*1024).spawn(move || {
        println!("I am thread1.");
    });
    // 等待新创建的线程执行完成
    new_thread_result.unwrap().join().unwrap();
}