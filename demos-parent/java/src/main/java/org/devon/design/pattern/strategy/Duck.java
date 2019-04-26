
package org.devon.design.pattern.strategy;

/**
 * @Describetion
 * @author Devonmusa
 * @date 2017年3月2日
 */
public abstract class Duck {

	private FlyingStrategy flyingStrategy;

	private QuackStrategy quackStrategy;

	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}
	
	public void setQuackStrategy(QuackStrategy quackStrategy) {
		this.quackStrategy = quackStrategy;
	}

	public void fly() {
		flyingStrategy.performanceFly();
	}

	public void quack() {
		quackStrategy.performanceQuack();
	}

	public abstract void display();

}
