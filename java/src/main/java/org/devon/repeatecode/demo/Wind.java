package org.devon.repeatecode.demo;
/**
*Describetion:向上转型
*@author  Devonmusa
*@version
*2017年2月10日 下午11:24:47
*
*/
class Instrument{
	
	public void play() {
		
	}
	
	static void tune(Instrument i) {
		i.play();
	}
}
public class Wind extends Instrument{
	
	
	public static void main(String[] args) {
		Wind wind = new Wind();
		Instrument.tune(wind);
	}

}
