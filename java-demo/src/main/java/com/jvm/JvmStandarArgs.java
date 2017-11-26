package com.jvm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 *
 * @author 
 * @date 2017年8月25日
 */
public class JvmStandarArgs {

	public JvmStandarArgs() {

	}

	/**
	 * C:\Users\lenovo>java -help 用法: java [-options] class [args...] (执行类) 或
	 * java [-options] -jar jarfile [args...] (执行 jar 文件) 其中选项包括: -d32 使用
	 * 32位数据模型 (如果可用) -d64 使用 64 位数据模型 (如果可用) -server 选择 "server" VM 默认 VM
	 * 是server.
	 * 
	 * -cp <目录和 zip/jar 文件的类搜索路径> -classpath <目录和 zip/jar 文件的类搜索路径> 用 ; 分隔的目录,
	 * JAR 档案 和 ZIP 档案列表, 用于搜索类文件。 -D<名称>=<值> 设置系统属性 -verbose:[class|gc|jni]
	 * 启用详细输出 -version 输出产品版本并退出 -version:<值> 警告: 此功能已过时, 将在
	 * 未来发行版中删除。需要指定的版本才能运行 -showversion 输出产品版本并继续 -jre-restrict-search |
	 * -no-jre-restrict-search 警告: 此功能已过时, 将在 未来发行版中删除。 在版本搜索中包括/排除用户专用 JRE -?
	 * -help 输出此帮助消息 -X 输出非标准选项的帮助 -ea[:<packagename>...|:<classname>]
	 * -enableassertions[:<packagename>...|:<classname>] 按指定的粒度启用断言
	 * -da[:<packagename>...|:<classname>]
	 * -disableassertions[:<packagename>...|:<classname>] 禁用具有指定粒度的断言 -esa |
	 * -enablesystemassertions 启用系统断言 -dsa | -disablesystemassertions 禁用系统断言
	 * -agentlib:<libname>[=<选项>] 加载本机代理库 <libname>, 例如 -agentlib:hprof 另请参阅
	 * -agentlib:jdwp=help 和 -agentlib:hprof=help
	 * -agentpath:<pathname>[=<选项>]按完整路径名加载本机代理库 -javaagent:<jarpath>[=<选项>] 加载
	 * Java 编程语言代理, 请参阅 java.lang.instrument -splash:<imagepath> 使用指定的图像显示启动屏幕
	 * 有关详细信息, 请参阅
	 * http://www.oracle.com/technetwork/java/javase/documentation/index.html。
	 */
	public void testStandarArgs() {
		// System.setProperty("-d64", "");

	}

	/**
	 * <p>
	 * C:\Users\lenovo>java -X
	 * </p>
	 * <p>
	 * -Xmixed 混合模式执行 (默认)
	 * </p>
	 * <p>
	 * -Xint 仅解释模式执行
	 * </p>
	 * <p>
	 * -Xbootclasspath:<用 ; 分隔的目录和 zip/jar 文件>
	 * </p>
	 * <p>
	 * 设置搜索路径以引导类和资源
	 * </p>
	 * <p>
	 * -Xbootclasspath/a:<用 ; 分隔的目录和 zip/jar 文件>
	 * </p>
	 * <p>
	 * 附加在引导类路径末尾
	 * </p>
	 * <p>
	 * -Xbootclasspath/p:<用 ; 分隔的目录和 zip/jar 文件>
	 * </p>
	 * <p>
	 * 置于引导类路径之前
	 * </p>
	 * <p>
	 * -Xdiag 显示附加诊断消息
	 * </p>
	 * <p>
	 * -Xnoclassgc 禁用类垃圾收集
	 * </p>
	 * <p>
	 * -Xincgc 启用增量垃圾收集
	 * </p>
	 * <p>
	 * -Xloggc:<file> 将 GC 状态记录在文件中 (带时间戳)
	 * </p>
	 * <p>
	 * -Xbatch 禁用后台编译
	 * </p>
	 * <p>
	 * -Xms<size> 设置初始 Java 堆大小
	 * </p>
	 * <p>
	 * -Xmx<size> 设置最大 Java 堆大小
	 * </p>
	 * <p>
	 * -Xss<size> 设置 Java 线程堆栈大小
	 * </p>
	 * <p>
	 * -Xprof 输出 cpu 配置文件数据
	 * </p>
	 * <p>
	 * -Xfuture 启用最严格的检查, 预期将来的默认值
	 * </p>
	 * <p>
	 * -Xrs 减少 Java/VM 对操作系统信号的使用 (请参阅文档)
	 * </p>
	 * <p>
	 * -Xcheck:jni 对 JNI 函数执行其他检查
	 * </p>
	 * <p>
	 * -Xshare:off 不尝试使用共享类数据
	 * </p>
	 * <p>
	 * -Xshare:auto 在可能的情况下使用共享类数据 (默认)
	 * </p>
	 * <p>
	 * -Xshare:on 要求使用共享类数据, 否则将失败。
	 * </p>
	 * <p>
	 * -XshowSettings 显示所有设置并继续
	 * </p>
	 * <p>
	 * -XshowSettings:all
	 * </p>
	 * <p>
	 * 显示所有设置并继续
	 * </p>
	 * <p>
	 * -XshowSettings:vm 显示所有与 vm 相关的设置并继续
	 * </p>
	 * <p>
	 * -XshowSettings:properties
	 * </p>
	 * <p>
	 * 显示所有属性设置并继续
	 * </p>
	 * <p>
	 * -XshowSettings:locale
	 * </p>
	 * <p>
	 * 显示所有与区域设置相关的设置并继续
	 * </p>
	 * <p>
	 * </p>
	 * <p>
	 * -X 选项是非标准选项, 如有更改, 恕不另行通知。
	 * </p>
	 */
	public void testNoneStandarXArgs() {

		String appHome = System.getProperty("user.dir");

	}

	public void testNoneStandarXXArgs() {
		// java -XX:+PrintFlagsFinal

		// java -XX:+PrintFlagsInitial

		// java -server -XX:+PrintCommandLineFlags

	}

	public void getSystemEnv() {
		Map<String, String> envMap = System.getenv();
		System.out.println("--------------System Env----------------------");
		for (Entry<String, String> entry : envMap.entrySet()) {
			System.out.println("KEY=" + entry.getKey() + ", \t\t\t VALUE=" + entry.getValue());
		}
	}

	public void getSystemProperties() {
		Properties systemProperties = System.getProperties();
		System.out.println("--------------System Properties----------------------");
		for (Entry<Object, Object> entry : systemProperties.entrySet()) {
			System.out.println("KEY=" + entry.getKey() + ", \t\t\t VALUE=" + entry.getValue());
		}

	}

	/**
	 * <p>
	 * -Xms128m
	 * </p>
	 * <p>
	 * -Xmx2g
	 * </p>
	 * <p>
	 * -XX:InitialHeapSize=128m
	 * </p>
	 * <p>
	 * -XX:MaxHeapSize=2g
	 * </p>
	 * <p>
	 * -XX:+HeapDumpOnOutOfMemoryError
	 * </p>
	 * <p>
	 * -XX:HeapDumpPath
	 * </p>
	 * <p>
	 * -XX:OnOutOfMemoryError
	 * </p>
	 * <p>
	 * -XX:PermSize jdk1.7
	 * </p>
	 * <p>
	 * -XX:MaxPermSize jdk1.7
	 * </p>
	 * <p>
	 * -XX:InitialCodeCacheSize
	 * </p>
	 * <p>
	 * -XX:ReservedCodeCacheSize
	 * </p>
	 * <p>
	 * -XX:NewSizes
	 * </p>
	 * <p>
	 * -XX:MaxNewSize
	 * </p>
	 * <p>
	 * -XX:+PrintCommandLineFlags
	 * </p>
	 * <p>
	 * -XX:+PrintGCDetails
	 * </p>
	 * <p>
	 * -XX:+PrintGCDateStamps
	 * </p>
	 * <p>
	 * -XX:+PrintTenuringDistribution new gc object age
	 * </p>
	 * <p>
	 * -Dfile.encoding=UTF-8
	 * </p>
	 * <p>
	 * -XX:+UseSerialGC serial gc one cpu core
	 * </p>
	 * <p>
	 * -XX:+UseParallelGC
	 * </p>
	 * <p>
	 * -XX:+UseParallelOldGC
	 * </p>
	 * <p>
	 * -XX:ParallelGCThreads=4
	 * </p>
	 * <p>
	 * -XX:-UseAdaptiveSizePolicy
	 * </p>
	 * <p>
	 * -XX:GCTimeRatio
	 * </p>
	 * <p>
	 * -XX:MaxGCPauseMillis
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		JvmStandarArgs jvmStandarArgs = new JvmStandarArgs();
		jvmStandarArgs.getSystemEnv();
		jvmStandarArgs.getSystemProperties();
		while (true) {
			jvmStandarArgs.testStandarArgs();
			jvmStandarArgs.testNoneStandarXArgs();

			try {
				Thread.sleep(60 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
