package org.devon.design.pattern.builder;
/**
*Describetion:
*@author  Devonmusa
*@version
*@date 2017年2月21日 下午11:29:05
*
*/
public class ActorController {

	public Actor construct(ActorBuilder actorBuilder) {
		Actor actor;
		actorBuilder.builderSex();
		actorBuilder.builderHireStyle();
		actorBuilder.builderFace();
		actorBuilder.builderType();
		
		actor = actorBuilder.createActor();
		return actor;
	}
	
}
