package at.crimsonbit.jgag.util;

import java.util.HashMap;
import java.util.Map;

public class GagUtils {
	/**
	 * Creates the 9gag service URL for specified service, path and args
	 * 
	 * @param service
	 * @param path
	 * @param args
	 * @return
	 */
	public static String createURL(Service service, String path, Map<String, String> args) {
		// Remove '/' that are not wanted
		StringBuilder sb = new StringBuilder();
		path = strip(path, '/');
		String ser = strip(service.getURL(), '/');
		
		append_with_delimiter(sb, '/', path);
		append_with_delimiter(sb, '/', ser);
		args.forEach((String key, String val) -> append_with_delimiter(sb, '/', key, val));
		
		return sb.toString();
	}
	
	public static String sendRequest(Method method, String path, Service service, boolean sign,
			Map<String, String> args, Map<String, String> body) {
		String url = createURL(service, path, args);
		Map<String, String> headers = new HashMap<>();
		headers.put("9GAG-9GAG_TOKEN", value)
		return null;
	}
	
	/**
	 * Appends a String and a char to a StringBuilder, makes the forEach easier
	 * 
	 * @param sb
	 * @param value
	 * @param delimiter
	 */
	private static void append_with_delimiter(StringBuilder sb, char delimiter, CharSequence... values) {
		for (CharSequence value : values) {
			sb.append(value);
			sb.append(delimiter);
		}
	}
	
	/**
	 * Removes the char c from the beginning and the end of the String s.
	 * Behaves much like {@link String#trim()}, except, that it lets you specify
	 * which characters should be removed
	 * 
	 * @param s
	 *            The String
	 * @param c
	 *            The char which should be removed
	 * @return a new String, with c removed in the beginning and at the end or
	 *         s, if no changes were made
	 */
	public static String strip(String s, char c) {
		char[] value = s.toCharArray();
		int len = value.length;
		int st = 0;
		char[] val = value; /* avoid getfield opcode */
		
		while ((st < len) && (val[st] <= ' ')) {
			st++;
		}
		while ((st < len) && (val[len - 1] <= ' ')) {
			len--;
		}
		return ((st > 0) || (len < value.length)) ? s.substring(st, len) : s;
	}
}
