package org.devon.framework.stream.flink.statistic.function;

import org.apache.flink.api.common.functions.RichFilterFunction;
import scala.Tuple2;

public class WordRichFilterFunction extends RichFilterFunction<Tuple2<String,String>> {
    @Override
    public boolean filter(Tuple2<String, String> stringStringTuple2) throws Exception {
        return false;
    }
}
