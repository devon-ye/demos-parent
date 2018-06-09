# mysql常用概念

## 事物
### 事物特性
  Atomicity(原子性)
   
      指事务包含的所有操作要么全部成功，要么全部失败回滚，因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影
  
  Consistency（一致性）
  
      指事务必须使数据库从一个一致性状态变换到另一个一致性状态，也就是说一个事务执行之前和执行之后都必须处于一致性状态.
  
  Isolation（隔离性）
      
      隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。
      
      即要达到这么一种效果：对于任意两个并发的事务T1和T2，在事务T1看来，T2要么在T1开始之前就已经结束，要么在T1结束之后才开始，这样每个事务都感觉不到有其他事务在并发地执行
      
  Durability（持久性）
  
      持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。
  
### 事物隔离级别
#### Read Uncommit
    即SELECT语句以非锁定的方式执行，会读取到其他会话已更新但未提交事物的数据，会产生脏读
#### Read Commited
    即使在同一个事务中，每次一致的读取都会设置并读取其自己的新快照。
      * 对于锁定读取（SELECT 使用For UPDATE或LOCK SHARE MODE）,UPDATE语句和DELETE语句,InnoDB只锁定索引记录，而不锁定他们之间的间隔,从而在锁定记录旁边自由插入新记录。间隙锁仅用于外键检查和重复主键检查。
        因为禁用了间隙锁，所以会出现幻影问题，因为其他会话可以将新记录插入间隙中。
      * 对于UPDATE或DELETE语句，InnoDB仅锁定更新或删除的行。在MySQL评估WHERE条件之后，释放不匹配行的记录锁。但这大大降低了死锁的可能性，但它们任然可能发生。
      * 对于UPDATE语句，如果某行被锁定，则InnoDB执行“半连续”读取，将最新的已提交版本返回给MySQL,以便MySQL可以确定该行是否与该WHERE条件匹配UPDATE,如果匹配则必须更新，否则MySQL再次读取行、这次InnoDB要么锁定它，要么等待锁定它
#### Read Repeateble
    mysql的默认隔离级别，在同一事物中一致读取第一次读取建立的快照，即在同一个事物内多个SELECT（非锁定）语句多次查询间是一致的
      * 对于具有唯一搜索条件的唯一索引，InnoDB仅锁定找到的索引记录，而不是锁定之前的记录间的间隔
      * 对于其他搜索条件，InnoDB锁定间隔或下一个主键锁来锁定扫描的搜索范围，以阻止其他会话插入到范围所覆盖的间隔中
#### Serializable
    即InnoDB隐式的将所有的普通SELECT语句转换为SELECT ... LOCK IN SHARE MODE语句,且AUTOCOMMIT被禁用。如果AUTOCOMMIT被启用，则SELECT是他自己的事物。


[mysql官网事物隔离级](https://dev.mysql.com/doc/refman/5.7/en/innodb-transaction-isolation-levels.html)

#### 脏读 
#### 幻读
      
      即相同的查询在同一事物中不同的时间查询结果不同
 

 

## 事物

## 索引
### 定义
  
### 索引存储分类
   * 聚集索引
      
         mysql每个的innodb表中都有一个聚集索引的特殊索引，其中存储行的数据（即行数据物理地址）。通常聚集索引和主键是同意的，即创建主键的同时会自动创建聚类索引。
   * 聚集索引自动创建顺序
   
         1）有主键（PRIMARY KEY）即以主键创建聚集索引
         2）没有主键的以唯一索引UNIQUE INDEX的第一个NOT NULL索引做为聚集索引
         3）即没有主键也没有合适的唯一索引的，则InnodDB内部自动生成一个隐藏的聚集索引GEN_CLUST_INDEX,该索引在包含行ID值的列列名上生成索引,行ID是6个字节的字段，单调递增    
         
   * 聚集索引如何加快查询速度
      
         通过聚集索引访问行很快，因为索引搜索直接导向包含所有行数据的页面。如果表很大，与使用与索引记录不同页面存储行数据的存储组织相比，聚簇索引体系结构通常会节省磁盘I / O操作。


   * 非聚集索引（二级索引）
      
         除聚集索引以外的所有索引都称为 二级索引。在中InnoDB，辅助索引中的每条记录都包含该行的主键列以及为辅助索引指定的列。 InnoDB使用此主键值搜索聚集索引中的行。
         
   * [mysql官网聚集索引和二级索引](https://dev.mysql.com/doc/refman/5.7/en/innodb-index-types.html)
   
### 索引存储结构分类
   
     * B+Tree （InnoDB存储引擎默认）包括：PRIMARY KEY， UNIQUE，INDEX和 FULLTEXT
     * Hash    （MEMOORY存储引擎）
     * R+Tree   空间类型的索引（InnoDB和MyISAM都支持空间类型索引的创建）
  
### 索引策略分类
  * 单列索引      
  * 多列索引
  * 前缀索引
  * 覆盖索引
  * 聚簇索引
  * 压缩索引
  * 重复索引

### 索引增删改
   新建索引
   
    CREATE INDEX index_name ON  table_name (column_name);
    CREATE UNIQUE INDEX index_name ON  table_name (column_name);
    CREATE PRIMARY KEY index_name ON  table_name (column_name);
   删除索引
 
    ALTER TABLE table_name DROP INDEX index_name (column_list)
    ALTER TABLE table_name DROP UNIQUE (column_list)
    ALTER TABLE table_name DROP PRIMARY KEY (column_list)
   新增或修改
   
    ALTER TABLE table_name ADD INDEX index_name (column_list)
    ALTER TABLE table_name ADD UNIQUE  (column_list)
    ALTER TABLE table_name ADD PRIMARY KEY (column_list)

## 引擎

### InnoBD
### MyISAM
### MEMORY
### ARCHIVE
### CSV
### MERGE

