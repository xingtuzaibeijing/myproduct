import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/23
 */
public class SetTest {
	public static void main(String[] args) {
		//hashSet 非线程安全
		Set<Object> hashSet = new HashSet<Object>();
		hashSet.add("");
		//继承自hashSet  非线程安全
		Set<Object> linkedHashSet = new LinkedHashSet<Object>();
		linkedHashSet.add("");
		//TreeSet非线程安全
		Set<Object> treeSet = new TreeSet<Object>();
		treeSet.add("");

	}
}
