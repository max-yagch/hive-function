package yang.udf.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 *
 */
public class TimeDiff extends UDF {
	/**
	 * 返回开始时间结束时间的差
	 *
	 * @param endTime
	 * @param startTime
	 * @param format
	 * @return
	 */
	public String evaluate(String endTime, String startTime, String format) {
		SimpleDateFormat dfs = new SimpleDateFormat(format);

		long diff = 0;
		Date end = null;
		Date start = null;
		try {
			end = dfs.parse(endTime);
			start = dfs.parse(startTime);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		diff = (end.getTime() - start.getTime());
		return Long.toString(diff);
	}

	/**
	 * 固定时间格式
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	public String evaluate(String endTime, String startTime) {
		String format = "yyyyMMdd";
		return evaluate(endTime, startTime, format);
	}
}