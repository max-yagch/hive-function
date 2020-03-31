package yang.udf.base;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import javax.swing.*;

/**
 * hive的自定义函数
 */
@Description(
		name = "Upper",
		value = "_FUNC_(str) - from the input string"
				+ "returns the value that is \"$str.toUpper\" ",
		extended = "Example:\n"
				+ " > SELECT _FUNC_(str) FROM src;"
)
public class Upper extends UDF{

	public String evaluate(String input){
		return input.toUpperCase();//将大写字母转换成小写
	}



}
