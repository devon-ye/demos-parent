package org.devon.connect;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月18日 下午9:29:22
*
*/
public class ConnectFactory implements IConnectFactory{

	
	public IConnectType connectType() {
		
		return new ConnectType();
	}

}
