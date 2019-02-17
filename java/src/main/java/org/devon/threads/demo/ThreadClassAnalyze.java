package org.devon.threads.demo;

public class ThreadClassAnalyze{
	
   public static void main(String[] args) {
	   ExtendsThread  et=new ExtendsThread();
	   et.start();
   }

   
}
class ExtendsThread  extends Thread{   
	   public void run(){
		   while(true){
			   System.err.println("Thread is running...");
			   threadTest();
		   }
	   }
	   @SuppressWarnings("static-access")
	public static void threadTest(){
		   ExtendsThread tca=new ExtendsThread();
		 //线程所拥有的属性
		   System.out.println("currentThread="+Thread.currentThread()+
				   "\ngetId()="+tca.getId()+
				   "\ngetPriority()="+tca.getPriority()+
				  // "\ncountStackFrames()="+tca.countStackFrames()+
				   "\nMAX_PRIORITY="+Thread.MAX_PRIORITY+
				   "\nMIN_PRIORITY="+tca.MIN_PRIORITY+
				   "\nNORM_PRIORITY="+tca.NORM_PRIORITY+
				   "\nactiveCount()="+tca.activeCount()+
				   "\ngetClass()="+tca.getClass()+
				   "\ngetState()="+tca.getState()+
				   "\ngetContextClassLoader()="+tca.getContextClassLoader()+
				   "\ngetThreadGroup()="+tca.getThreadGroup()+
//				   "\ngetStackTrace()="+tca.getStackTrace()+
				   "\ngetAllStackTraces()="+Thread.getAllStackTraces()+
				   "\ngetUncaughtExceptionHandler()="+tca.getUncaughtExceptionHandler()+
				   "\ngetDefaultUncaughtExceptionHandler()="+tca.getDefaultUncaughtExceptionHandler()+
				   "\nisAlive()="+tca.isAlive()+
				   "\nisDaemon()="+tca.isDaemon()+
				   "\nisInterrupted()="+tca.isInterrupted()+
				   //"\nenumerate(null)="+tca.enumerate(null)+
//				   "\nequals(null)="+tca.equals(null)+
				   "\nhashCode()="+tca.hashCode()+
				   "\ntoString()="+tca.toString()  
				   );
	   }
}
