package entity;
import lombok.Data;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2019/1/23
 */
@Data
public class User {
	private int age;

	private String name;

	@Override
	public String toString() {
		return "User{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
