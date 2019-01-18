package org.qhs.myproduct;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 程序启动类
 * @date 2018/11/9
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(value = "org.qhs.myproduct")
@MapperScan(value ="org.qhs.myproduct.mapper")
public class SpringBootStartApplication {
	public static void main(String[] args) {
		System.out.println("");
		new SpringApplicationBuilder(SpringBootStartApplication.class).run(args);
	}
}
