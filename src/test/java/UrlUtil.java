/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/4
 */
public class UrlUtil {
	public static void main(String[] args) {
		getparams("uriBuilder.addParameter", "https://weibo.com/p/aj/v6/mblog/mbloglist?ajwvr=6&domain=100505&is_hot=1&pagebar=0&pl_name=Pl_Official_MyProfileFeed__21&id=1005051731230547&script_uri=/529150120&feed_type=0&page=1&pre_page=1&domain_op=100505&__rnd=1544840409762");
	}

	/**
	 * @param url url
	 * @return void
	 * @description 将url的参数提出
	 * @author QianHuaSheng
	 * @date 2018/12/04 05:48:16
	 */
	public static void getparams(String before, String url) {
//		url = "https://weibo.com/p/aj/v6/mblog/mbloglist?ajwvr=6&domain=100505&is_search=0&visible=0&is_all=1&is_tag=0&profile_ftype=1&page=1&pagebar=0&pl_name=Pl_Official_MyProfileFeed__21&id=1005051853425063&script_uri=/331333731&feed_type=0&pre_page=2&domain_op=100505&__rnd=1543915837783";
		//按照？分割
		String[] hash = url.split("\\?");
		//取第二个 按照&分割
		String[] params = hash[1].split("&");
		//循环
		String[] split;
		for (String param : params) {
			split = param.split("=");
			if("__rnd".equals(split[0])||"page".equals(split[0])||"pagebar".equals(split[0])){
				continue;
			}
			System.out.println(before+"(\"" + split[0] + "\",\"" + split[1] + "\");");
		}
	}
}
