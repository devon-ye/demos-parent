package org.devon.framework.stream.flink.statistic.sink;

import org.apache.flink.api.common.io.RichOutputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;


import java.io.IOException;

public class HBaseOutputFormatSink extends RichOutputFormat<Tuple2<String, Integer>> {
    private Configuration configuration;
    @Override
    public void configure(Configuration configuration) {
        this.configuration =(Configuration)getRuntimeContext().getExecutionConfig().getGlobalJobParameters();

    }

    @Override
    public void open(int i, int i1) throws IOException {
      int workSize =   configuration.getInteger("work.size",1);
        System.out.println(workSize);
    }

    @Override
    public void writeRecord(Tuple2<String, Integer> tuple2) throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
