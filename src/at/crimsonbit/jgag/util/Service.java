package at.crimsonbit.jgag.util;


public enum Service {
	API("http://api.9gag.com"),
	COMMENT_CDN("http://comment-cdn.9gag.com"),
	NOTIFY("http://notify.9gag.com"),
	AD("http://ad.9gag.com"),
	ADMIN("http://admin.9gag.com");
	
	private String url;
	
	private Service(String url) {

		this.url = url;
	}

	public String getURL() {
		return url;
	}
}
