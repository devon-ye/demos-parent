package org.devon.framework.stream.flink.statistic.source;

import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * @author dewen.ye
 * @date 2019/3/9 21:10
 */
public class SimpleSource implements SourceFunction<String>, CheckpointedFunction {
  private long count = 0L;
   private volatile boolean isRunning = true;
    @Override
    public void snapshotState(FunctionSnapshotContext functionSnapshotContext) throws Exception {

    }

    @Override
    public void initializeState(FunctionInitializationContext functionInitializationContext) throws Exception {

    }

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {
            while (isRunning && count <1000){
               synchronized (sourceContext.getCheckpointLock()){
                   sourceContext.collect(count+"");
                   count++;
               }
            }
    }

    @Override
    public void cancel() {
           isRunning = false;
    }
}
