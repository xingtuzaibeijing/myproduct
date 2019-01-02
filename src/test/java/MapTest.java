import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description maptest
 * @date 2018/12/23
 */
public class MapTest {
	public static void main(String[] args) {
		//hashMap
		Map hashMap = new HashMap<Object, Object>();
		hashMap.put(1, "12");
		hashMap.get("");
		//TreeMap 非线程安全
		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
		treeMap.put("","");
		//hashtable 线程安全
		Hashtable<Object, Object> hashtable = new Hashtable<Object, Object>();
		hashtable.put("","");
		//分段锁
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
		concurrentHashMap.put("", "");

	}
}
