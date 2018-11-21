package so.dun.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * String Advanced Tool
 *
 * @author dunso
 */
public class StringAdvanceUtil {

	/**
	 * 将str字符串转化为map对象，由split1将str切割为一个个的kv字符串，由split2将kv字符串切割为kv键值对，然后放入map中
	 * 放入map的过程中，可对键值对进行处理，repRex是一个正则表达式，根据它对键值对进行替换处理
	 *
	 * @param str    要放入map的字符串
	 * @param split1 根据它将str切割为一个个的kv字符串
	 * @param split2 根据它将kv字符串切割为kv键值对
	 * @param repRex 根据它对kv键值对做替换处理，如去除字符串里面的空格、特殊字符（"，\n, tab"）等等
	 * @return <code>Optional<Map<String, String>></code>
	 */
	public static Optional<Map<String, String>> splitStr2Map(String str, String split1, String split2, String repRex) {

		Optional<Pattern> pattern = Optional.ofNullable(repRex).map(Pattern::compile);
		Map<String, String> hashMap = new HashMap<>();

		Optional.ofNullable(str)
			.map(s -> Optional.ofNullable(split1)
				.map(s::split)
				.filter(kv1 -> kv1.length > 1)
				.orElse(null))
			.map(array -> {
					Arrays.stream(array).forEach(s -> Optional.ofNullable(split2)
						.map(s::split)
						.filter(kv2 -> kv2.length > 1)
						.map(kv2 -> hashMap.put(
							pattern.map(p -> p.matcher(kv2[0]).replaceAll("")).orElse(kv2[0]),
							pattern.map(p -> p.matcher(kv2[1]).replaceAll("")).orElse(kv2[1]))
						).orElse(null)
					);
					return null;
				}
			).orElse(null);
		return Optional.of(hashMap);
	}
}
