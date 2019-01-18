/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2019/1/17
 */
public class ForTest {
	public static void main(String[] args) {
	     for(int i=0,len=10;i<len;i++){
			 for(int j=0,glen=10;j<glen;j++){
			 	System.out.println("j"+j);
			 	if(j==5){
			 		break;
				}
			 }
			 System.out.println("i"+i);
	     }
	}
}
