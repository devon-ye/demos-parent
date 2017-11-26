package org.devonmusa.util.error;
/**
*@author  Devonmusa
*@date 2017年1月17日 
*
*/
@SuppressWarnings("serial")
public class OSExecuteUtilException extends RuntimeException {
	public OSExecuteUtilException(String errorInfo){
		super(errorInfo);
	}
}
