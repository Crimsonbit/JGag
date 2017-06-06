package at.neonartworks.ninesearch.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import at.neonartworks.ninesearch.utils.GagSection;
import at.neonartworks.ninesearch.utils.GagUtils;

/**********************************************************************
 * | Project : 9Gag Search API V2
 *
 * Program name : GagPost.java
 *
 * Author : Florian Wagner aka. neonartworks
 *
 * Date created : 06.06.2017
 *
 * Purpose : Small and basic 9gag search api.
 * 
 *
 * Revision History : |
 **********************************************************************/
public class GagSearchV2 {

	private List<GagPost> posts = new ArrayList<GagPost>();
	private URL url;
	private InputStream is = null;
	private BufferedReader br;
	private String line;
	private StringBuilder sb = new StringBuilder();

	public GagSearchV2() {
	}

	/**
	 * Initializes the 9gag search. This HAS to be called before any other
	 * search function.
	 * 
	 * @param query
	 *            The search query
	 * @throws IOException
	 */
	public void initSearch(String query) throws IOException {
		query = query.replaceAll(" ", "+");
		url = new URL(GagUtils.getSearchLink() + query);
		GagUtils.initSearch(url, is, br, line, sb);

	}

	/**
	 * Searches 9 gag and retrieves the first few results found.F
	 * 
	 * @return List containing all Posts found
	 */
	public List<GagPost> search() {
		List<String> rawList = GagUtils.filter(sb.toString());
		posts = GagUtils.createPostEntries(rawList);
		return posts;
	}

	/**
	 * Gets the first ten results of the given section s. The posts are returned
	 * in an List<GagPost>
	 * 
	 * @param s
	 *            the section you want to get the posts
	 * @return List<GagPost> containing the first ten results
	 * @throws IOException
	 */
	public List<GagPost> getFromSection(GagSection s) throws IOException {

		url = new URL(GagUtils.GetSectionLink() + GagUtils.refactorSection(s));
		GagUtils.initSearch(url, is, br, line, sb);
		
		System.out.println(url.toString());

		List<String> rawList = GagUtils.filterSection(sb.toString());
		posts = GagUtils.createPostFromSectionEntries(rawList);
		return posts;

	}

}