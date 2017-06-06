package at.neonartworks.main.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import at.neonartworks.ninesearch.core.GagPost;
import at.neonartworks.ninesearch.core.GagSearchV2;
import at.neonartworks.ninesearch.utils.GagSection;

public class GMain {

	private static List<GagPost> posts = new ArrayList<GagPost>();

	public static void main(String[] args) {
		GagSearchV2 gs = new GagSearchV2();

		try {
			posts = gs.getFromSection(GagSection.HOT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (GagPost p : posts) {

			BufferedImage img = null;
			try {
				img = p.getImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new NeoPreview(img, img.getWidth(), img.getHeight(), p.getGag_link());

		}

	}

}
