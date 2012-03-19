package de.m4gu5.leetconverter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.res.AssetManager;
import android.content.res.Resources;

public class Convert2Leet {

	public String convertIt(String normalString, Resources resources) {

		AssetManager assetManager = resources.getAssets();

		Properties alphabet = null;
		try {
			InputStream inputStream = assetManager.open("alphabet.properties");
			alphabet = new Properties();
			alphabet.load(inputStream);
		} catch (IOException e) {
			// Do nothing because this part of code is virtually unreachable
		}

		char[] normalCharArray = normalString.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : normalCharArray) {
			if (alphabet.getProperty(String.valueOf(c).toUpperCase()) != null) {
				sb.append(alphabet.getProperty(String.valueOf(c).toUpperCase()));
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

}
