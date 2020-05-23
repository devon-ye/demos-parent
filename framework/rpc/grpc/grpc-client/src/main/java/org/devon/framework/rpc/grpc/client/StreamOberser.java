package org.devon.framework.rpc.grpc.client;

import java.util.stream.Stream;

/**
 * @author devon.ye
 * @datetime 2020/5/10 7:48 AM
 * @since
 */
public class StreamOberser {


	public void obser(Stream source) {

		final class FlowController implements Runnable {
			@Override
			public void run() {
               source.limit(1);
			}
		}
	}
}
