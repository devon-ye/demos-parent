package com.design.pattern.prototype;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月21日 下午10:46:28
*
*/
public class WeeklyLog implements Cloneable{
	private  String name;
    private  String date;
    private  String content;

    @Override
    public WeeklyLog clone(){
    	Object object = null;
    	try {
			object = super.clone();
			return (WeeklyLog)object;
		} catch (CloneNotSupportedException e) {	
			e.printStackTrace();
			return null;
		}
		    	
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
}
