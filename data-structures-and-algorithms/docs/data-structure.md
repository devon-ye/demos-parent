# 数据结构

## 存储结构(storage structure)
 
|存储结构|定义|优点|缺点|
|:-------------:|:----------------------------------:|:----------------------------:|:--------------:| 
|顺序存储结构|既逻辑上连续的数据结构在物理存储上也是连续的|可利用CPU的高速缓存、因CPU加载数据时按块加载连续的块|内存内存分配时，如果剩余`连续内存块`小于要分配内存块，即使空闲`非连续内存块`大于要分配的内存块，也会分配失败 |
|链式存储结构|既逻辑上连续的数据结构物理上存储不一定连续，用节点表示，节点包括数据和指向其它节点的指针|分配内存时 |1.因数据存储时还要存储指针，故对小数据对象来说内存浪费比较严重、内存碎片化更严重 2.CPU高速缓存无法充分利用|
## 基础数据结构 （Basic Data Structure）
|数据结构             |存储结构|优点|缺点| 最优操作|
|:--------------------:|:----------:|:----------------------------------------------------------:|:------------------------------------:|:------------------------------------------------------:|
|数组|顺序存储结构|通过索引可以直接访问任意元素|初始化时就需要知道元素的数量|基于index索引的查找|
|链表|链式存储结构|使用的空间大小和元素数量成正比|需要通过引用访问任意元素|插入或删除元素|



## 数据结构分类

### 集合结构

#### 哈希表
    概念：即给定K值对应f(K)哈希函数得映象V,K经过f(K)哈希函数映射，有且只有一个V，并且V在一个有限得连续得密集区间内,除此之外能够处理哈希冲突将K映射到V区间上;
    哈希因子（） = 表中装入的记录数/哈希表长度;
  

### 线性结构

     概念：即n个元素的有限序列，线性表中的元素必定有相同的特性（即属于同一对像）
#### 线性表的顺序表示
    数组：用一组连地址连续的存储单元存储线性表的数据元素。
#### 线性表的链式表示
    链表：即物理连续或非连续的节点存储线性表的数据元素

  


   
#### STACK 栈

   * 定义


     即仅限定在表尾进行插入删除操作的线性表，表尾即栈顶（top），表头即栈底（bottom），且栈中元素先进后出，后进先出。栈的顺序存储结构是用一组连续的存储单元依次存放自栈底到栈顶的的数据元素。
   * 双端栈
                           
         既数组的头和尾都是栈底，栈顶向数组中间靠拢
        
   * 操作
     
     
      入栈
      出栈 
#### HEAP(堆)
    
   * 定义
        
            父节点的值一定不大于或不小于子节点的值。堆被认为在计算机算法中起到重要作用，并被用于各种编程语言
            
            二叉堆是一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级存储（不使用数组的第一个位置）
            
   
   * 二叉堆
            
            
#### Queue 队列
    队列是一种先进先出的线性表，它只允许在表的一端插入，另一端删除元素


### 一元多项式的表示

### 树形结构

### 
### 二叉搜索树

#### 平衡二叉树

#### 红黑树

### 图形结构
#### 无向图
#### 有向图


## 抽象数据结构（Abstract Data Structure）


|数据结构             |中文名|特点|操作|
|:--------------------:|:----------------:|:----------------------------------------------------------:|:------------------------------------:|
|stack|堆栈|先进后出||
|Queue|队列|先进先出|||
|Map|哈希表|||
|List||||
|Set||||







