package org.elasticsearch.plugin.analysis.basic;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.SplitAnalyzerProvider;
import org.elasticsearch.index.analysis.SplitTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 * @author zhangxianbin
 *
 *         2020年6月4日
 */
public class BasicSplitPlugin extends Plugin implements AnalysisPlugin {

	public static String PLUGIN_NAME = "analysis-basicsplit";

	@Override
	public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
		Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();
		extra.put("basicsplit", SplitTokenizerFactory::getSplitTokenizerFactory);
		return extra;
	}

	@Override
	public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
		Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();

		extra.put("basicsplit", SplitAnalyzerProvider::getAplitAnalyzerProvider);

		return extra;
	}

}
