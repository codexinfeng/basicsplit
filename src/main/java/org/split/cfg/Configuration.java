package org.split.cfg;

import java.io.File;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.io.PathUtils;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.plugin.analysis.basic.BasicSplitPlugin;
import org.split.dic.Dictionary;
import java.nio.file.Path;

/**
 * @author zhangxianbin
 *
 *         2020年6月4日
 */
public class Configuration {

	private Environment environment;
	private Settings settings;

	// 是否启用小写处理
	private boolean enableLowercase = true;

	@Inject
	public Configuration(Environment env, Settings settings) {
		this.environment = env;
		this.settings = settings;

		this.enableLowercase = settings.get("enable_lowercase", "true").equals("true");

		Dictionary.initial(this);

	}

	// 测试时使用的构造函数
	public Configuration( boolean enable_lowercase) {
		this.enableLowercase = enable_lowercase;

		Dictionary.initial(this);
	}

	public Path getConfigInPluginDir() {
		return PathUtils
				.get(new File(BasicSplitPlugin.class.getProtectionDomain().getCodeSource().getLocation().getPath())
						.getParent(),
						"config").toAbsolutePath();
	}

	public Environment getEnvironment() {
		return environment;
	}

	public Settings getSettings() {
		return settings;
	}

	public boolean isEnableLowercase() {
		return enableLowercase;
	}

}
