//3-singleton
//created:11/01/2018
//last modified:11/01/2018

public class Singleton {

	public static void main(String[] args) {
		Earth earth = Earth.getEarth();  //“类的方法”这种方式从外部调用getEarth()方法
		System.out.println(earth.getAge());
	}
}

class Earth {

	private Earth() {}  //构造函数，无返回值。
	                    //必须是private，不能让外部的函数调用它
//============================================================
//====== private这个放在内部，public这个方法是从外部取 ===========
	private static Earth earth = new Earth(); //定义和初始化在一行
	//定义一个Earth类型的变量earth.并限定这个变量的权限private.
	//而且，单例只能实力化一次，所以加static
	//初始化就用new赋值
	public static Earth getEarth() {
		return earth;
	}
//============================================================
	private int age = 1000;   //定义和初始化在一行
	public int getAge() {
		return age;
	}

}