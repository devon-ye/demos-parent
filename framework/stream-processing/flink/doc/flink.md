# Flink

## 概念

* JobManager

* TaskManager

       Slot: 均分TaskManager进程内的内存

* Source

* Operator
        
        map
        flatMap
        filter
        reduce
        aggregation
        process
        
        OperatorChain

* Sink

* StateBackend
     
         checkpoint
         savepoint

* Window

* Time
        
        EventTime
        IngestionTime
        ProcessTime


## Design

### Back Pressure（反压）

### Memory Segment