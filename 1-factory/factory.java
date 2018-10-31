//1-factory
//created:10/30/18
//last edited:10/30/18

public class Factory_Method {
	public void static main (String[] args) {
		Animals cat = new AnimalsFactory("cat");
		cat.name();
	}
}

interface Animals {
	public void name();
} 

class Cat implements Animals {
    public Cat () {

    }

	public void getName() {
		System.out.println("this is a cat.");
	}
}

class AnimalsFactory {
	public AnimalsFactory() {

	}
}