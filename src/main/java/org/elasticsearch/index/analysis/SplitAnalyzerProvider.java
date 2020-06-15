package org.elasticsearch.index.analysis;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.split.cfg.Configuration;
import org.split.lucene.SplitAnalyzer;

public class SplitAnalyzerProvider extends AbstractIndexAnalyzerProvider<SplitAnalyzer> {
	private final SplitAnalyzer analyzer;

	public SplitAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);

		Configuration configuration = new Configuration(env, settings);

		analyzer = new SplitAnalyzer(configuration);
	}

	public static SplitAnalyzerProvider getAplitAnalyzerProvider(IndexSettings indexSettings, Environment env,
			String name, Settings settings) {
		return new SplitAnalyzerProvider(indexSettings, env, name, settings);
	}

	@Override
	public SplitAnalyzer get() {
		return this.analyzer;
	}
}
