package com.io.character;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileWriterReader {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("d://1.txt");
			BufferedReader br = new BufferedReader(fr);

			String str;
			int line = 1;
			while ((str = br.readLine()) != null) {
				System.out.println(line + ":" + str);
				line++;
			}

			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
