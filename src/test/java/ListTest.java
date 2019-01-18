import java.util.ArrayList;
import java.util.List;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description list测试
 * @date 2018/12/11
 */
public class ListTest {
	public static void main(String[] args) {
		//vector 线程安全
//		List vector=new Vector();
//		vector.add("");
//		vector.get(1);
//		vector.remove("");
		List<Object> arrayList = new ArrayList();
		arrayList.add("12");
		arrayList.remove(1);
		arrayList.get(1);
		arrayList.add(1,12);
		arrayList.size();
//		***************************************************************
//		测试arrayList数组copy(arraylist数组删除的做法) 从下标加一的位置copy起 覆盖原有的 最后一个赋值null(让cg处理)
//		Integer[] intArrays = new Integer[]{1, 2, 3, 4, 5};
//		int elementCount = intArrays.length;
//		int index = 2;
//		if (index >= elementCount) {
//			throw new ArrayIndexOutOfBoundsException(index + " >= " +
//					elementCount);
//		} else if (index < 0) {
//			throw new ArrayIndexOutOfBoundsException(index);
//		}
//		int j = elementCount - index - 1;
//		if (j > 0) {
////			src:源数组；
////			srcPos:源数组要复制的起始位置；
////			dest:目的数组；
////			destPos:目的数组放置的起始位置；
////			length:复制的长度；
//			System.arraycopy(intArrays, index + 1, intArrays, index, j);
//		}
//		elementCount--;
//		intArrays[elementCount] = null; /* to let gc do its work */
//		System.out.println(intArrays[4]);
//		********************************************************
//		List<String> linkedList = new LinkedList();
//		linkedList.add("");
//		linkedList.get(1);
//		Iterator iterator = list.iterator();
//		while (iterator.){
//
//		}
//		list.add();
//		list
//		LinkedHashMap linkedHashMap = new LinkedHashMap();

//		//原本的数组
//		HashMap.Node<K,V>[] tab;
//
//		HashMap.Node<K,V> first, e;
//		// n是数组的长度
//		int n; K k;
//		if ((tab = table) != null && (n = tab.length) > 0 &&
//				(first = tab[(n - 1) & hash]) != null) {
//			if (first.hash == hash && // always check first node
//					((k = first.key) == key || (key != null && key.equals(k))))
//				return first;
//			if ((e = first.next) != null) {
//				if (first instanceof HashMap.TreeNode)
//					return ((HashMap.TreeNode<K,V>)first).getTreeNode(hash, key);
//				do {
//					if (e.hash == hash &&
//							((k = e.key) == key || (key != null && key.equals(k))))
//						return e;
//				} while ((e = e.next) != null);
//			}
//		}
//		return null;


//		***************************
//		HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
//		if ((tab = table) == null || (n = tab.length) == 0)
//			n = (tab = resize()).length;
//		if ((p = tab[i = (n - 1) & hash]) == null)
//			tab[i] = newNode(hash, key, value, null);
//		else {
//			HashMap.Node<K,V> e; K k;
//			if (p.hash == hash &&
//					((k = p.key) == key || (key != null && key.equals(k))))
//				e = p;
//			else if (p instanceof HashMap.TreeNode)
//				e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//			else {
//				for (int binCount = 0; ; ++binCount) {
//					if ((e = p.next) == null) {
//						p.next = newNode(hash, key, value, null);
//						if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//							treeifyBin(tab, hash);
//						break;
//					}
//					if (e.hash == hash &&
//							((k = e.key) == key || (key != null && key.equals(k))))
//						break;
//					p = e;
//				}
//			}
//			if (e != null) { // existing mapping for key
//				V oldValue = e.value;
//				if (!onlyIfAbsent || oldValue == null)
//					e.value = value;
//				afterNodeAccess(e);
//				return oldValue;
//			}
//		}
//		++modCount;
//		if (++size > threshold)
//			resize();
//		afterNodeInsertion(evict);
//		return null;
//
//		int i=1&100;
//		System.out.println(i);
//		arrayList删除元素
//		List<String> remove =new ArrayList();
//		remove.add("12");
//		remove.add("2");
//		remove.add("2");
//		remove.add("1");
		//反序
//		for(int len=remove.size(), i=len-1;i >= 0;i--){
//			String o = remove.get(i);
//			if(o =="2"){
//		    	System.out.println("我要删除了");
//				remove.remove(o);
//			}
//		}
		//正序
//		remove.remove("2");
//		for(int i=0;i<remove.size();i++){
//			String o = remove.get(i);
//			if(o =="2"){
//				System.out.println("我要删除了");
//
//			}
//		}
////
//		for (String str : remove) {
//			System.out.println("12");
//			if (str.equals("2")) {
//				remove.remove(str);
//			}
//		}
//		for(int i=0;i<remove.size();i++){
//			System.out.println(remove.get(i));
//		}
		//二分法
//		String[] arrays = {"12", "2","1", "12"};
//		int i = Arrays.binarySearch(arrays, "12");
//		int i1 = twoSeacher(0, arrays.length, "1", arrays);
//		System.out.println(i1);
//		System.out.println(i);22
	}


	/**
	 * @param formIndex 从哪个下标开始
	 * @param endIndex  到哪里结束
	 * @param key       查找值
	 * @param arrays    数组
	 * @return int
	 * @description
	 * @author QianHuaSheng
	 * @date 2018/12/21 11:49:40
	 */
	public static int twoSeacher(Integer formIndex, Integer endIndex, String key, String[] arrays) {
		//把范围缩小一半
		int range = (formIndex + endIndex) >> 1;
		//比较在前还是在后 如果相等直接返回下标
		Comparable array = arrays[range];
		int i = array.compareTo(key);
		//在后 递归调用 从开始下标到（结束下标/2）
		if (i < 0) {
			twoSeacher(formIndex, endIndex >> 2, key, arrays);
		}
		//在前递归调用 从（开始下标/2）到 结束下标
		if (i < 0) {
			twoSeacher(formIndex >> 2, endIndex, key, arrays);
		}
		//相等直接返回
		if (i == 0) {
			return range;
		}
		return Integer.parseInt(null);
	}

//	public synchronized void removeElementAt(int index 8) {
//		modCount++;
//		if (index >= elementCount 10) {
//			throw new ArrayIndexOutOfBoundsException(index + " >= " +
//					elementCount);
//		}
//		else if (index < 0) {
//			throw new ArrayIndexOutOfBoundsException(index);
//		}
//		int j = elementCount - index - 1; 10-8-1  1
//		if (j > 0) {
//			System.arraycopy(elementData,  index + 1,  elementData, index, j);
//		}
//		elementCount--;
//		elementData[elementCount] = null; /* to let gc do its work */
//	}

}
