package com.china.gavin.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class FetchAllPostTitle {
	Logger log = Logger.getLogger(FetchAllPostTitle.class);

	/**
	 * 从指定的url中获取该url中所有的帖子标题
	 * 
	 * @param url
	 * @return
	 */
	private List<String> obtainAllPostTitle(String url) {
		List<String> allTitle = new ArrayList<String>();
		StringBuilder htmlInfo = new StringBuilder();
		BufferedReader context = null;
		try {
			URL newUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) newUrl
					.openConnection();
			context = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String lineInfo = null;
			while ((lineInfo = context.readLine()) != null) {
				htmlInfo.append(lineInfo).append("\n");
			}
			// System.out.println(htmlInfo.toString());

			Pattern p = Pattern.compile("<td class=\"title\">[.\\s\\S]*?</td>");
			Matcher m = p.matcher(htmlInfo.toString());
			while (m.find()) {
				String val = m.group();
				Pattern pTitle = Pattern.compile("title=\"(.*?)\"");
				Matcher mTitle = pTitle.matcher(val);
				while (mTitle.find()) {
					// System.out.println(mTitle.group(1));
					String title = mTitle.group(1);
					if (title != null && !"".equals(title)) {
						allTitle.add(title);
					}
				}
			}
		} catch (MalformedURLException e) {
			log.debug("Url is error , please validate !");
			e.printStackTrace();
		} catch (IOException e) {
			log.debug("The URL address is invalid , please validate !");
			e.printStackTrace();
		} finally {
			try {
				context.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return allTitle;
	}

	public static void main(String[] args) {
		FetchAllPostTitle ct = new FetchAllPostTitle();
		List<String> allTitle = ct
				.obtainAllPostTitle("http://bbs.csdn.net/forums/Java");
		for (int i = 0; i < allTitle.size(); i++) {
			System.out.println("Title " + (i + 1) + " : " + allTitle.get(i));
		}
	}
}
