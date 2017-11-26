package com.design.pattern.builder;


/**
*
*@author  Devonmusa
*@version
*2017年2月21日 下午11:14:17
*
*/
public abstract class ActorBuilder {
	
	protected Actor actor = new Actor();
	
	public abstract void builderType();
	public abstract void builderSex();
	public abstract void builderFace();
	public abstract void builderCustume();
	public abstract void builderHireStyle();
	
	public Actor createActor() {
		return actor;
	}
	
}
