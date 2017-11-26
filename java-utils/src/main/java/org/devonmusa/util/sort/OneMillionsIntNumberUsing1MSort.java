package org.devonmusa.util.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneMillionsIntNumberUsing1MSort {
	private static Logger logger = LoggerFactory.getLogger(OneMillionsIntNumberUsing1MSort.class);
	private static String fileName = "D:/workspace/Eclipse/utils/data/1MillionsIntNumber.txt";
	private static String sortedFileName = "D:/workspace/Eclipse/utils/data/sortedIntNumber.txt";
	private final int COUNT = 10000000;
	private final int MAX = 99999999;

	public static void main(String[] args) {
		OneMillionsIntNumberUsing1MSort using1mSort = new OneMillionsIntNumberUsing1MSort();

		Long startTime = System.currentTimeMillis();
		// using1mSort.productIntNumberWriteFile(fileName);
		Byte[] bytes = using1mSort.OneMllionIntNumberUseLeastMemorySort(fileName);
		// using1mSort.printfSortedNumber(bytes);
		using1mSort.writeSortedNumberIntoFile(bytes, sortedFileName);
		Long endTime = System.currentTimeMillis();
		logger.info("Used time:" + (endTime - startTime));
	}

	public Byte[] OneMllionIntNumberUseLeastMemorySort(String filename) {
		File file = new File(filename);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedReader bufferedReader = null;
		String tempString = null;
		Byte[] bytes = new Byte[MAX];
		int tempInt = 0;
		try {
			if (fileReader != null) {
				bufferedReader = new BufferedReader(fileReader);
			}
			if (bufferedReader != null) {
				;
				while ((tempString =  bufferedReader.readLine())  != null) {
					tempInt = Integer.valueOf(tempString);
					bytes[tempInt] = 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return bytes;
	}

	public void writeSortedNumberIntoFile(Byte[] bytes, String sortedFileName) {
		File file = new File(sortedFileName);
		logger.info("file path" + file);
		FileWriter fileWriter = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int len = 0;
		if (bytes != null) {
			len = bytes.length;
			logger.info("data byteArray legth:" + len);
		}
		try {
			for (int i = 0; i < len; i++) {
				if (bytes[i] == null) {
					continue;
				} else {
					fileWriter.write(i + "\n");
					logger.info("Sorted number write to file:"+i);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void printfSortedNumber(Byte[] bytes) {
		int len = 0;
		if (bytes != null) {
			len = bytes.length;
		}

		for (int i = 0; i < len; i++) {
			if (bytes[i] != null) {
				logger.info("number:" + i + " flag:" + bytes[i]);
			}
		}
	}

	public void productIntNumberWriteFile(String fileName) {
		File file = new File(fileName);
		FileWriter fileWriter = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fileWriter = new FileWriter(file, true);
			Random random = new Random();
			int tempNumber = 0;
			int i = 0;
			while (i < COUNT) {
				tempNumber = random.nextInt(MAX);
				if (tempNumber > COUNT && tempNumber < MAX) {
					fileWriter.write(tempNumber + "\n");
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
