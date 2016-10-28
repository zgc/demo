package futureDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * 建立一个线程池，里面有三个线程，三个线程都执行完并取得返回的执行结果之后，再执行主线程
 * 使用invokeAll来实现
 * @author Administrator
 *
 */
public class FutureDemo2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService pool = Executors.newCachedThreadPool();
		
		long  begin = System.currentTimeMillis();
		MyCallable task1 = new MyCallable("www.syshop.com", 1500);
		MyCallable task2 = new MyCallable("www.google.com.hk", 3000);
		MyCallable task3 = new MyCallable("www.google.com.hk", 2000);
		MyCallable task4 = new MyCallable("www.google.com.hk", 4000);
		CallableForUser userTask = new CallableForUser("machine");
		
		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		tasks.add(userTask);	
		
		//执行完线程池中的任务再继续执行主线程
		List<Future<String>> results = pool.invokeAll(tasks);
		pool.shutdown();
		System.out.println("\t");
		for(Future<String> result : results){
			System.out.println("执行结果:"+result.get());
		}
		long  end = System.currentTimeMillis();
		System.out.println("执行完毕,总时间:"+(end-begin)+"ms");
	}
}
