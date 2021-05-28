# 链表结构 Link List Structure




## 常见操作

    
   * 插入节点
        * 头部添加
     
     1.  生成当前新节点
     2.  新节点的next指针指向原来的头节点
     3.  将当前节点的引用赋给头节点
     
     * 尾部添加
     1.  生成当前节点
     2.  遍历链表找到尾节点
     3.  尾节点指针指向当前节点
     
     * 中间添加
     
     1.  生成待插入节点
     2.  遍历链表找到插入节点的前驱节点
     3.  拿出后继节点
     4.  待插入节点next指针指向后继节点
     5.  前驱节点next指针指向当前节点

   
   * 删除节点
    * 头部删除
   
    * 尾部删除
   
    * 中间删除
   
       1. 获取前驱节点
       2.  获取后继节点
       3. 将前驱节点的next指向后继节点   

   * 反转


      思想1：就地翻转
      
      思想2：放入数组，从数组尾部读入
      
      思想3：递归

 

   * 合并

## 链表遍历思路

 	快慢指针：即在同一循环中块指针单词走两步以上，慢指针只走一步
    双指针：即在整个算法中一个指针记录已处理数据偏移，另一指针记录当前需要处理偏移


## 实现类型

### 单链表

### 循环链表
      
* 实现
```java
    public class LoopLinkedList{
        
        class Node<E>{
            Node next=this; //单节点环实现
            E data;
        }
        
        
        ...
    }
```
      
### 双向链表


* 实现
```java
    public class DoubleLinkedList{
        
        class Node<E>{
            Node pre;  //前驱指针
            Node next; //后继指针
            E data;    //数据元素
        }
        
        
        ....
    }


```

### 双向循环链表


* 实现
```java
  public class DoubleLoopLinkedList{
      
      class Node<E>{
          
      }
      
      
  }

```




## 链表常见算法

### 1.移除倒数第n个节点

* 思路一
            
        两次遍历，第一次获得链表长度,第二次移除（L-N）+1就节点，为了方便处理单节点链表，在链表头部添加辅助节点后 ，移除节点就变为（L-N节点）
 时间复杂度：O(n)

 空间复杂度：O(1)
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
        length++;
        first = first.next;
    }
    //removeIndex = (L-N)+1 添加辅助节点后变为removeIndex =（L-N）
    length -= n;
    first = dummy;
    //用辅助节点从链表头部走到 removeIndex
    while (length > 0) {
        length--;
        first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
}
```

*思路二
               
               快慢指针： 首先快指针走n+1步，然后快慢指针一起走，此时快指针总比慢指针多n+1步，最终快指针走到尾部时，慢指针刚好到倒数n-1的位置
    
时间复杂度：O(n)

空间复杂度：O(1)

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast= dummy;
    ListNode slow = dummy;
   
   //快指针先走n+1
   for(int i = 1 ; i <= n+1; i++){
       fast = fast.next;
   }
    //快慢指针一块走 快指针到尾节点，满指针才到倒数n-1  
    while (fast!= null) {
        fast= fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```


### 2.顺序双链表合并为顺序链表

* 思路


    双链表前n个数同时遍历，对比大小，添加到辅助链表里，当其中有一个链表走到尾节点时，跳出双链表循环，将大链表剩余的节点追加到辅助链表尾部

```java
public ListNode mergeTwoLists(ListNode l1,ListNode l2){
    ListNode p =new  ListNode(0);
    ListNode q = p;
    whiel(l1 != null && l2 != null){
        if(l1.val > l2.val){
            p.next = l2;
            l2 = l2.next;
        }else{
             p.next = l1;
            l1 = l1.next;
        }
        //关键步骤p指针后移
        p = p.next;
    }
    
    if(l1 != null){
        p.next = l1;
    }
    
    if(l2 != null){
        p.next =l2;
    }
    
    return q.next;
}
```

### 3.合并K个链表

* 思路一

        外层循环从链表数组中每次取出一条链表 内层循环 两个链表比较大小合并

  时间复杂度：kn？
  
  空间复杂度：
  
```java
public ListNode mergeKLists(ListNode[] lists){
    ListNode dummy =new  ListNode(0);
     dummy.next = lists[0];
    for(int i = 1; i < lists.length; i++){
       List second = list[i];
       dummy =mergeTwoList(dummy,second);
    }
    
    returen dummy.next;
}

private ListNode mergeTwoList(ListNode l1,ListNode l2){
   ListNode p =new  ListNode(0);
    ListNode q = p;
    whiel(l1 != null && l2 != null){
        if(l1.val > l2.val){
            p.next = l2;
            l2 = l2.next;
        }else{
             p.next = l1;
            l1 = l1.next;
        }
        //关键步骤p指针后移
        p = p.next;
    }
    
    if(l1 != null){
        p.next = l1;
    }
    
    if(l2 != null){
        p.next =l2;
    }
    
    return q.next;
}
```

### 4.链表节点两两交换 后返回头结点！



* 思路

```java
public static  ListNode swapPairs(ListNode head) {
    ListNode result = new ListNode(0);
    ListNode dummy = result;
    ListNode next = null;
    while(head != null && head.next != null){

        dummy.next = head.next;

        head.next = null;
        //取出两个后面的指针
        next = dummy.next.next;

        dummy.next.next  = head;

        head = next;

        dummy = dummy.next.next;
    }
    if(head != null){
        dummy.next =head;
    }
    return result.next;
}
```

