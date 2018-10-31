//1-factory
//created:10/30/18
//last edited:10/30/18

public class factory {
	public static void main (String[] args) {
		AnimalsFactory animalFactory = new AnimalsFactory(); //先实例化一个工厂，什么都不生产
		Animals cat = animalFactory.getAnimals("cat"); //动用getAnimal()方法生产一个猫
		Animals dog = animalFactory.getAnimals("dog");
		cat.getName();
		dog.getName();
	}
}

interface Animals {
	void getName();
} 

class Cat implements Animals {  //只要不需要传值初始化，就不需要写构造函数
	@Override
	public void getName() {
		System.out.println("this is a cat.");
	}
}

class Dog implements Animals {
	@Override
	public void getName() {
		System.out.println("this is a dog.");
	}
}

class AnimalsFactory {
	public Animals getAnimals(String name) {  //不支持建工厂的同时刻立即生产动物，
		if(name.equalsIgnoreCase("cat"))      //所以只写方法即可，不用构造函数
			return new Cat();
		else if(name.equalsIgnoreCase("dog"))
			return new Dog();
		else
			return null;
	}
}

