//2-abstract-factory
//created:10/31/2018
//last edited:10/31/2018

class Abstract_Factory {

	//生产工厂的方法
	public static AbstractFactory getFactory(String factoryName) {  //返回值可以是抽象类的类名:AbstractFactory
		if (factoryName.equalsIgnoreCase("animals")) {              //???为什么要加static??
			return new AnimalsFactory();
		}
		else if (factoryName.equalsIgnoreCase("others")) {
			return new OthersFactory();
		}
        else {
        	return null;
        }
	}

	public static void main(String[] args) {
		//注意：此处虽然是建造新工厂，但没有new。因为不是实例化类得到的，而是调用方法得到的。
		AbstractFactory animalsFactory = getFactory("animals");  
		//此处返回的类名可以是抽象类名AbstractFactory(要与上面getFactory()定义一致)
		//不能是实体类名AnimalsFactory,因为不能保证getFactory()就一定返回AnimalsFactory类型。
		Animals cat = animalsFactory.getAnimals("cat");
		cat.getName();
	}
}
//=========================================================
//设一个抽象类，只是“某种工厂”，拓展为实体类时候再指定“生产什么的工厂”
//把“有可能是哪种工厂”的可能性，能力，先用抽象方法的形式列出来
abstract class AbstractFactory {
	abstract Animals getAnimals(String name); 
	abstract Objects getObjects(); 
}

//动物工厂
//实体类要把抽象类的所有方法都重写
class AnimalsFactory extends AbstractFactory {  
	public Animals getAnimals(String name) {
		if (name.equalsIgnoreCase("cat")) {
			return new Cat();
		} else {
			return null;
		}
	}

    @Override
	public Objects getObjects() {
		return null;
	}
}

//其他工厂
class OthersFactory extends AbstractFactory {
	@Override
	public Animals getAnimals(String name) {
		return null;
	}

	public Objects getObjects() {
		return null;
	}
}
//==========================================
interface Animals {
	void getName();   //接口方法不用修饰权限
}

class Cat implements Animals {  
	@Override
	public void getName() {  //实现为类，重写方法时再添加权限
		System.out.println("this is a cat.");
	}
}

interface Objects {
}

class Object implements Objects { //类名不能和接口名一样
}
	
