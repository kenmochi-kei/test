package jp.co.internous.action;

public class Test {

	public static void main(String[] args) {
		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		System.out.println(taro.name);
		System.out.println(taro.age);

		Person jiro = new Person("jiro",18);
		System.out.println(jiro.name);
		System.out.println(jiro.age);

		Person saburou = new Person("saburou");
		saburou.age = 24;
		System.out.println(saburou.name);
		System.out.println(saburou.age);
	}

}
