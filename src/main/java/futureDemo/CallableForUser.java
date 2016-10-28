package futureDemo;

import java.util.concurrent.Callable;

public class CallableForUser implements Callable<String> {

	private String username;
	
	public CallableForUser(String username){
		this.username = username;
	}
	
	@Override
	public String call() throws Exception {
		User user = new User();
		user.setUsername(username);
		return user.getUsername();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
