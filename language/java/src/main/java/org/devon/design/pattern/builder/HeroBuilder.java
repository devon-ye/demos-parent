package org.devon.design.pattern.builder;

/**
 * Describetion:
 * 
 * @author Devonmusa
 * @version 2017年2月21日 下午11:20:24
 *
 */
public class HeroBuilder extends ActorBuilder {

	@Override
	public void builderType() {
		actor.setType("英雄");
	}

	@Override
	public void builderSex() {
		actor.setSex("男");
	}

	@Override
	public void builderFace() {
		actor.setFace("英俊");
	}

	@Override
	public void builderCustume() {
		actor.setCostume("盔甲");
	}

	@Override
	public void builderHireStyle() {
		actor.setHairstyle("飘逸");
	}

}
