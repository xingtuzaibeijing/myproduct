import java.util.Arrays;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 算法 位移符
 * @date 2018/12/13
 */
public class ArithmeticTest {
	public static void main(String[] args) {
		//位移符
		Integer [] iLenth=new Integer[10];

		for(int i=0,len=10;i<len;i++){
			int random = (int) (Math.random()*(10-1+1));
			iLenth[i]=random;
		}
		//数组快速查找（二分法）
		Arrays.binarySearch(iLenth,1);
		//10的二进制 1010  0000 1010 右移一位 0000 0101  1*2(0)+0*2(1)+1*2(2) 5
		System.out.println(10>>>1);
		//10的二进制 1010  0000 1010 右移一位 0001 0100  转10进制 0*2(0)+0*2(1)+1*2(2)+0*2(3)+1*2(4) 20
		System.out.println(10<<1);
		System.out.println(10>>1);
	}
}
