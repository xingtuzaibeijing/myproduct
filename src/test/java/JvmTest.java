/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/3
 */
public class JvmTest {
	public static void main(String[] args) {
		String abc="abc";
		System.out.println(abc.hashCode());
		String ab="ab";
		System.out.println(ab.hashCode());
		ab="abc";
		System.out.println(ab.hashCode());
		System.out.println(ab==abc);
//		String a="a";
//		String b="a";
//		System.out.println(a==b);

//		String s1 = "a";
//		String s2 = "b";
//		String str6 = s1 + s2;
//		System.out.println(str6 == "ab");

//		String a = "ab1";
//		String b = "ab1";
//		System.out.println(a == b);
	}

}
