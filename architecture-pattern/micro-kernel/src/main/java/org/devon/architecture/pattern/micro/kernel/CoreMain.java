package org.devon.architecture.pattern.micro.kernel;

import org.devon.architecture.pattern.micro.kernel.core.Plugin;

import java.util.ServiceLoader;

public class CoreMain {


    public static void main(String[] args) {
        ServiceLoader<Plugin> pluginServiceLoader = ServiceLoader.load(Plugin.class);
        for (Plugin plugin : pluginServiceLoader) {
            System.out.printf("plugin:"+plugin);
        }
    }


}
