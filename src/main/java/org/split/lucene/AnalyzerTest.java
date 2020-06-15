package org.split.lucene;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.split.cfg.Configuration;

/**
 * @author zhangxianbin
 *
 *         2020年6月4日
 */
public class AnalyzerTest {

	public static void main(String[] args) throws Exception {
		String text = "2018款 奥迪A3 30周年年型 Limousine 40 TFSI 运动型";

		Configuration configuration = new Configuration(true);

		// 创建分词对象
		Analyzer anal = new SplitAnalyzer(configuration);
		StringReader reader = new StringReader(text);
		// 分词
		TokenStream ts = anal.tokenStream("", reader);
		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
		// 遍历分词数据
		ts.reset();
		while (ts.incrementToken()) {
			System.out.print(term.toString() + "|");
		}
		reader.close();
	}
}
