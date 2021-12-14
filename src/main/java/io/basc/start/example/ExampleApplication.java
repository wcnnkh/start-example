package io.basc.start.example;

import javax.servlet.annotation.MultipartConfig;

import io.basc.framework.beans.annotation.Bean;
import io.basc.framework.boot.support.MainApplication;
import io.basc.framework.db.DB;
import io.basc.framework.env.Sys;
import io.basc.framework.io.FileUtils;
import io.basc.framework.sqlite.SQLiteDB;
import io.basc.framework.upload.Uploader;
import io.basc.framework.web.pattern.annotation.RequestMapping;
import io.basc.framework.web.resource.StaticResourceRegistry;

@RequestMapping
@MultipartConfig
public class ExampleApplication {

	/**
	 * 启动后访问http://localhost:8080/hello
	 * 
	 * @see ExampleApplication#helloworld()
	 * 
	 *      因为导入了start-manage-system模块，所以可以访问默认的后台管理系统(http://localhost:8080/admin)
	 * @param args
	 */
	public static void main(String[] args) {
		MainApplication.run(ExampleApplication.class, args);
	}

	/**
	 * 示例Controller
	 * 
	 * @return
	 */
	@RequestMapping(value = "hello")
	public String helloworld() {
		return "hello world";
	}

	/**
	 * 使用内嵌的sqlite为示例数据库
	 * 
	 * @return
	 */
	@Bean
	public DB getDB() {
		return new SQLiteDB(Sys.env.getWorkPath() + "/start-example.db");
	}

	/**
	 * 注册静态资源
	 * 
	 * @return
	 */
	@Bean
	public StaticResourceRegistry getStaticResourceRegistry() {
		StaticResourceRegistry resourceLoader = new StaticResourceRegistry();
		resourceLoader.add("*.html", "/html/");
		return resourceLoader;
	}

	@Bean
	public Uploader getUploader() {
		return new Uploader(FileUtils.getTempDirectory());
	}
}
