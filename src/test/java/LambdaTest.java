import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description lambda表达式
 * @date 2019/1/23
 */
public class LambdaTest {
	public static void main(String[] args) {
		List<User> stringList = new ArrayList();
		User user;
		Integer age;
		List<Integer> ages = new ArrayList<>();
		for (int i = 0, len = 10; i < len; i++) {
			user = new User();
			age = getAge(ages);
			user.setAge(age);
			user.setName("今天是个好日子");
			ages.add(age);
			stringList.add(user);
		}
//		for (User user1:stringList){
//			System.out.println(user1.toString());
//		}
//		stringList.forEach(item->{
//			System.out.println(item.toString());
//		});
//		stringList.stream()cool;
		//*****************************使用 lambda 比较函数******************************
//		Comparator comparator=new Comparator<User>() {
//			@Override
//			public int compare(User user1, User user2) {
//				return user1.getAge()-user2.getAge();
//			}
//		};
//		Collections.sort(stringList,comparator);
//		for(User i : stringList){
//			System.out.println(i.toString());
//		}
		stringList.sort((user1, user2) -> user1.getAge() - user2.getAge());
		//**********************************断言****************************************
		stringList.forEach(System.out::println);
		//***********************************函数式接口@FunctionalInterface**************
		Thread thread = new Thread(() -> System.out.println("1"));
		thread.start();
		//*********************************list转Map*******************************
		Map<Integer, String> collect = stringList.stream().collect(Collectors.toMap(User::getAge, User::getName));
	}

	private static Integer getAge(List list) {
		int age = (int) (1 + Math.random() * (20 - 1 + 1));
		if (list.contains(age)) {
			getAge(list);
		}
		return age;
	}
}
