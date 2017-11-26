package org.devonmusa.util.database.connect;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月18日 下午9:28:19
*
*/
public class DBUtils {
	
	public static void main(String[] args) {
		IConnectFactory  connectFactory =new ConnectFactory();
		IConnectType connectType = connectFactory.connectType();
		connectType.conncetMySQL();
	}
}
