import java.util.ArrayList;
import java.util.List;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 冒泡排序
 * @date 2018/12/19
 */
public class BubbleSort {
	public static void main(String[] args) {
		//往数组里放10个内容
		int [] arrays=new int[10];
		for (int i = 0, len = 10; i < len; i++) {
			arrays[i]=(int)( 1+Math.random()*100);
		}
		//进行选择排序 循环数组 一个获得最大的
//		Integer tmpInt;
//		for(int i=0,len=arrays.length-1;i<len;i++){
//			for(int j=i;j<len+1;j++){
//			    if(arrays[i]<=arrays[j]){
//					tmpInt=arrays[j];
//					arrays[j]=arrays[i];
//					arrays[i]=tmpInt;
//				}
//			}
//		}
//		冒泡排序
		int tmpInt;
		for(int i=0,len=arrays.length-1;i<len;i++){
		    for(int j=0,temLen=len-i;j<temLen;j++){
		        if(arrays[j]>arrays[j+1]){
					tmpInt=arrays[j+1];
					arrays[j+1]=arrays[j];
					arrays[j]=tmpInt;
				}
		    }
		}
		List list=new ArrayList();
//		list.add();
		String a="abc";
//		String[] split = a.split("");
//		System.out.println(split.toString());
	}
}
