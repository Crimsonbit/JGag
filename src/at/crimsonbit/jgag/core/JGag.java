package at.crimsonbit.jgag.core;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JGag {

	private String client_name;
	private String client_secret;
	private MessageDigest md;
	public JGag() {
	}

	public void login(String client_name, String client_secret) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.client_name = client_name;
		
		//create instance of messagedigest
		md = MessageDigest.getInstance("MD5");
		
		byte[] secret_in = client_secret.getBytes("UTF-8");
		byte[] secret_out = md.digest(secret_in);
		
		this.client_secret = new String(secret_out, StandardCharsets.UTF_8);
		System.out.println(this.client_secret);
	}

	public static void main(String[] args) {
		JGag g = new JGag();

		try {
			g.login("NeonArtworks", "awd");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
