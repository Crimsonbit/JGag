package at.crimsonbit.jgag.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class HTTP_Helper {
	
	private final String charset = StandardCharsets.UTF_8.name();
	
	/**
	 * 
	 * @param url
	 *            the url
	 * @param query
	 *            A Mapping of query params to query values (e.g. id=131)
	 * @param optArgs
	 *            Optional Arguments, such as headers
	 * @return the resulting InputStream
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public InputStream get(String url, Map<String, String> query, EnumMap<Argument, Object> optArgs)
			throws MalformedURLException, IOException {
		String q;
		HttpClient client = HttpClientBuilder.create().build();
		
		// Convert the query map to a String
		StringBuilder sb = new StringBuilder();
		if (query != null) {
			Iterator<Entry<String, String>> iter = query.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, String> entry = iter.next();
				sb.append(URLEncoder.encode(entry.getKey(), charset));
				sb.append('=');
				sb.append(URLEncoder.encode(entry.getValue(), charset));
				if (iter.hasNext())
					sb.append('&');
			}
		}
		q = sb.toString();
		
		URL obj = new URL(url + '?' + q);
		RequestConfig conf = RequestConfig.custom().build();
		return null;
	}
	
	public String post(String url, Map<String, String> query) {
		return null;
	}
	
	public static enum Argument {
		HEADERS;
	}
}
