package at.crimsonbit.jgag.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HTTP_Helper {
	
	private final String charset = StandardCharsets.UTF_8.name();
	
	public String get(String url, Map<String, Object> query) throws MalformedURLException, IOException {
		String q;
		
		StringBuilder sb = new StringBuilder();
		if (query != null) {
			Iterator<Entry<String, Object>> iter = query.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, Object> entry = iter.next();
				sb.append(URLEncoder.encode(entry.getKey(), charset));
				sb.append('=');
				sb.append(URLEncoder.encode(entry.getValue().toString(), charset));
				if (iter.hasNext())
					sb.append('&');
			}
		}
		q = sb.toString();
		URLConnection con = new URL(url + "?" + q).openConnection();
		return null;
	}
	
	public String post(String url, Map<String, Object> query) {
		return null;
	}
}
