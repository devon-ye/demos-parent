# linux常用命令


## cpu

more /proc/cpuinfo |grep "physical id"|uniq|wc -l

* 物理cpu核数

        cat /proc/cpuinfo |grep "physical id"|sort |uniq|wc -l
* 逻辑CPU核数

        cat /proc/cpuinfo |grep "processor"|wc -l
* CPU主频

        cat /proc/cpuinfo |grep MHz|uniq
* 操作系统内核信息

        uname -a
        Linux l-noah6vaoshexl1.auto.beta.cn0 2.6.32-504.el6.x86_64 #1 SMP Wed Oct 15 04:27:16 UTC 2014 x86_64 x86_64 x86_64 GNU/Linux

* 

ulimit – n

* 统计当前打开的文件句柄
   
   
            lsof|awk '{print $2}'|wc -l

*  统计文件句柄打开数并倒叙排列，倒数第二列进程号

        lsof|awk '{print $2}'|sort|uniq -c|sort -nr|more

## top

* 执行结果
![image](./img/top-command.png)

### 详解

* 第一行

* 第二行

* 第三行  CPU状态

       6.7% us — 用户空间占用CPU的百分比。
       0.4% sy — 内核空间占用CPU的百分比。
       0.0% ni — 改变过优先级的进程占用CPU的百分比
       92.9% id — 空闲CPU百分比
       0.0% wa — IO等待占用CPU的百分比
       0.0% hi — 硬中断（Hardware IRQ）占用CPU的百分比
       0.0% si — 软中断（Software Interrupts）占用CPU的百分比

* 第四行：内存状态

           8306544k total — 物理内存总量（8GB）
           7775876k used — 使用中的内存总量（7.7GB）
           530668k free — 空闲内存总量（530M）
           79236k buffers — 缓存的内存量 （79M）
           
* 第五行：swap交换分区

        2031608k total — 交换区总量（2GB）
        2556k used — 使用的交换区总量（2.5M）
        2029052k free — 空闲交换区总量（2GB）
        4231276k cached — 缓冲的交换区总量（4GB）
 * 第七行 开始
           
|PID  |USER  |  PR  |  NI  | VIRT |  RES | SHR  |S| %CPU  |%MEM |TIME+ |COMMAND|
|---- |------|------|------|------|------|------|--------------|-------|-----|------|-------|
|进程号|进程所有者用户|进程优先级|  进程的nice值（介于-20 到 +19之间，值越大，越谦让）|进程占用的虚拟内存总量|进程占用的物理内存总量|进程和其他进程共享的内存总量 |     |CPU使用率|内存使用率|自进程启动到目前为止的CPU时间总量|进程所对应的命令行名称，也就是启动的程序名|



#### 服务链接查看
netstat -anp |  grep serverPort

#### 根据端口找服务 
     lsof -i:PORT


文件句柄查看

内存查看

CPU负载查看

磁盘占用查看

日志查看

gc日志
中间件日志
框架日志
服务日志