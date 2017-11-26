package org.devonmusa.util.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.devonmusa.util.error.OSExecuteUtilException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
*@author  Devonmusa
*@version
*2017年1月17日 下午9:24:19
*
*/
public class OSExecuteUtil {
	private static Logger log = LoggerFactory.getLogger(OSExecuteUtil.class);

	private OSExecuteUtil() {
		throw new Error("OSExecuteUtil class is forbiden instance!");
	}

	public static void command(String command) {
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
			BufferedReader bf = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bf.readLine()) != null) {
				System.out.println(str);
			}

			InputStreamReader inputStreamReaderError = new InputStreamReader(process.getErrorStream());
			BufferedReader errors = new BufferedReader(inputStreamReaderError);
			while ((str = errors.readLine()) != null) {
				System.err.println(str);
				err = true;
			}

		} catch (IOException e) {
			if (!command.startsWith("CMD /C")) {
				command("CMD /C " + command);
			} else {
				throw new RuntimeException(e);
			}
			log.error("OSExecuteUtil.command(String command)  IOException:" + e);
		}
		if (err) {
			throw new OSExecuteUtilException("OSExecuteUtil execute error:" + command);
		}
	}

}
