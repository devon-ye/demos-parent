package org.devon.framework.rpc.zero.ice;

/**
 * @author dewen.ye
 * @date 2019/1/19 10:44
 */
public class ZeroIceDemo {

    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -p 10000");
          
        }
    }
}
