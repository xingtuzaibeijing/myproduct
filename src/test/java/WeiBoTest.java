import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/12/4
 */
public class WeiBoTest {

	private final static String downFile = "D:\\素材\\微博gif\\素材库";
	private final static String url = "https://weibo.com/p/aj/v6/mblog/mbloglist";

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		//获取微博往下刷新的页面
		CloseableHttpClient aDefault = HttpClients.createDefault();
		URIBuilder uriBuilder;
		//1-100
		for (int i = 0, len = 100; i < len; i++) {
			for (int j = 0, jlen = 1; j < jlen; j++) {
				uriBuilder = new URIBuilder(url);
				uriBuilder.addParameter("ajwvr","6");
				uriBuilder.addParameter("domain","100505");
				uriBuilder.addParameter("is_hot","1");
				uriBuilder.addParameter("pl_name","Pl_Official_MyProfileFeed__21");
				uriBuilder.addParameter("id","1005051731230547");
				uriBuilder.addParameter("script_uri","/529150120");
				uriBuilder.addParameter("feed_type","0");
				uriBuilder.addParameter("pre_page","1");
				uriBuilder.addParameter("domain_op","100505");
//				不用变
				uriBuilder.addParameter("__rnd", System.currentTimeMillis() + "");
				uriBuilder.addParameter("page", i + "");
				uriBuilder.addParameter("pagebar", j + "");
				System.out.println("************************************************************" + j + "*********************************************************");
				HttpGet httpGet = new HttpGet(uriBuilder.build());
				httpGet.setHeader("Cookie", "SINAGLOBAL=5554786780969.226.1529573240002; _ga=GA1.2.2100773049.1533948305; __gads=ID=a6a527ef847bba06:T=1533948310:S=ALNI_MZ5bNxfq20EvYkh0yQahKvEEQTVCg; un=15674917079; UOR=www.jijidown.com,widget.weibo.com,www.baidu.com; wvr=6; Ugrow-G0=57484c7c1ded49566c905773d5d00f82; login_sid_t=a615c8bf9d542399a423a70115dda12a; cross_origin_proto=SSL; YF-V5-G0=c99031715427fe982b79bf287ae448f6; WBStorage=bfb29263adc46711|undefined; _s_tentry=passport.weibo.com; Apache=1257111459087.8164.1544840287972; ULV=1544840287979:20:11:3:1257111459087.8164.1544840287972:1544437169877; wb_view_log=1920*10801; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WhrmXXTbYhIQN2Q6HX6JKmY5JpX5K2hUgL.Foq7eh57e0-4eKM2dJLoIp7LxKML1KBLBKnLxKqL1hnLBoMceh57ehef1K2N; SSOLoginState=1544840295; ALF=1576376305; SCF=Ahlg0Z0o2Zxh8qqLAnebCyweycPEDtuFsH7ikZZHD73cFRDaWKLPywDbl6nC--XjGPE8CPRW2TxQG8xASJpZtQo.; SUB=_2A25xEBQhDeRhGeBO61IR8yvFyjuIHXVSZALprDV8PUNbmtBeLW_4kW9NSkYAxkbTdydRYwALWe1tzSRSXXwGCDXD; SUHB=08J7GHURQ1hw-8; wb_view_log_6000035917=1920*10801; YF-Page-G0=e44a6a701dd9c412116754ca0e3c82c3; wb_timefeed_6000035917=1");
				httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
				httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
				httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
				httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
				httpGet.setHeader("Accept", "*/*");
				httpGet.setHeader("Referer", "https://weibo.com/331333731?from=myfollow_all^&is_all=1");
				httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
				httpGet.setHeader("Connection", "keep-alive");
				CloseableHttpResponse execute = aDefault.execute(httpGet);
				HttpEntity entity = execute.getEntity();
				//获取data数据
				String entityStr = EntityUtils.toString(entity);
				JSONObject entityJson = (JSONObject) JSONObject.parse(entityStr);
				String data = entityJson.get("data").toString();
				if (StringUtils.isEmpty(data)) {
					System.out.println("--------------------获取data为空------------------");
					continue;
				}
				Document document = Jsoup.parse(data);
				//根据class获取到组件
				Elements wbPics = document.getElementsByClass("WB_pic");
				Elements wbTexts = document.getElementsByClass("WB_text");
				Node node;
				Node testNode;
				String title = null;
				int textSize;
				for (int m = 0, size = wbPics.size(); m < size; m++) {
					//得到属性
					node = wbPics.get(m);
					System.out.println(node);
					textSize = wbTexts.size();
					if (textSize > m) {
						testNode = wbTexts.get(m);
						title = testNode.childNode(0).toString();
					}
					if (StringUtils.isEmpty(title)||title.contains("/")||title.contains("\\")) {
						title =System.currentTimeMillis()+"";
					}
					String attr = node.attr("action-data");
					String[] values = attr.split("&");
					for (String value : values) {
						if (value.startsWith("gif_url=")) {
							String gifurl = value.replace("gif_url=", "");
							//解码处理
							if (StringUtils.isEmpty(gifurl)) {
								System.out.println("121");
								continue;
							}
							String gifUrl = URLDecoder.decode(gifurl, "GBK");
							//下载gif
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
							title=title.replace(" ","");
							downLoadFromUrl("http:" + gifUrl, title.trim() + ".mp4", downFile + "/" + sdf.format(new Date()));
						}
					}
				}
				Thread.sleep(5000);
			}

		}
	}

	/**
	 * 从网络Url中下载文件
	 *
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	private static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		//得到输入流
		InputStream inputStream = null;
		try {
			inputStream = conn.getInputStream();
		} catch (Exception e) {
			System.out.println("2121");
		}
		//获取自己数组
		byte[] getData = readInputStream(inputStream);
		//文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("*****************************************"+"异常路径："+urlStr+"名称"+fileName+"******************************************");
			return;
		}
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
//		System.out.println("info:" + url + " download success");
	}


	/**
	 * 从输入流中获取字节数组
	 *
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
}
