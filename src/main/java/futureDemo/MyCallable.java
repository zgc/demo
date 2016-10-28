package futureDemo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	
	public MyCallable() {
		super();
	}

	public MyCallable(String url, int n) {
		super();
		this.url = url;
		this.n = n;
	}

	private String url;
	private int n;
	
	@Override
	public String call() throws Exception {
		String reStr = "";
		long begin = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			Thread.sleep(1);
			if(i == n-1){
				long end = System.currentTimeMillis();
				long time = end-begin;
				reStr = "访问路径是"+url+",用时"+time+"ms";
				System.out.println(reStr);
			}
		}
		return reStr;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
