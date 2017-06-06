package at.crimsonbit.jgag.core;

public class JGag {

	private String client_name;
	private String client_secret;

	public JGag() {
	}

	public void login(String client_name, String client_secret) {
		this.client_name = client_name;
		this.client_secret = client_secret;

	}
	
	
	
	
}
