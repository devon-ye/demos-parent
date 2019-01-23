package org.devon.zero.ice.demo;

/**
 * @author dewen.ye
 * @date 2019/1/19 10:44
 */
public class ZeroIceDemo {

    public static void main(String[] args) {
        int status = 0;
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args)) {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
            //
            //注册关闭挂钩以在JVM关闭期间销毁通信器
            //
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                communicator.destroy();
            }));
        }
        // communicator在这里自动销毁
        System.exit(status);
    }
}
