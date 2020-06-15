package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.split.cfg.Configuration;
import org.split.lucene.SplitTokenizer;

/**
 * @author zhangxianbin
 *
 *         2020年6月4日
 */
public class SplitTokenizerFactory extends AbstractTokenizerFactory {

	private Configuration configuration;

	public SplitTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, settings);
		configuration = new Configuration(env, settings);
	}

	public static SplitTokenizerFactory getSplitTokenizerFactory(IndexSettings indexSettings, Environment env,
			String name, Settings settings) {
		return new SplitTokenizerFactory(indexSettings, env, name, settings);
	}

	@Override
	public Tokenizer create() {
		return new SplitTokenizer(configuration);
	}

}
