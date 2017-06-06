package at.crimsonbit.jgag.util;

/**
 * This Class lists all possible 9gag sub-api URLs
 * 
 * @author Alexander Daum
 *
 */
public enum Services {
	API("http://api.9gag.com"),
	COMMENT_CDN("http://comment-cdn.9gag.com"),
	NOTIFY("http://notify.9gag.com"),
	AD("http://ad.9gag.com"),
	ADMIN("http://admin.9gag.com");
	
	private String url;
	
	private Services(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return url;
	}
}
