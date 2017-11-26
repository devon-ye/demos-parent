package com.io.fileoperate;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {
		File file = new File("D:/Tomcat");
		ListFiles.listFiles(file);
	}

	public static void listFiles(File file) {

		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			if (files == null || files.length == 0) {
				return;
			}
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				if (f.exists() && f.isDirectory()) {
					listFiles(f);
				}

			}
		}

	}

}
