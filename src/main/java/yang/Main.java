package yang;

import yang.udf.base.EBPPlatformOverview;
import yang.udf.base.TimeDiff;
import yang.udf.base.Upper;

public class Main {
	public static void main(String[] args) {

		EBPPlatformOverview ebpPlatformOverview = new EBPPlatformOverview();
		ebpPlatformOverview.evaluate("[{\"projectName\":\"开发测试02\",\"projectPrefix\":\"kf_pro2\",\"databaseName\":\"kf_pro2_ods\",\"tableName\":\"test_student_ods\",\"storage\":\"0\"},{\"projectName\":\"开发测试02\",\"projectPrefix\":\"kf_pro2\",\"databaseName\":\"kf_pro2_dwd\",\"tableName\":\"test_student_dwd\",\"storage\":\"0\"},{\"projectName\":\"开发测试02\",\"projectPrefix\":\"kf_pro2\",\"databaseName\":\"kf_pro2_dwd\",\"tableName\":\"test_student_dwd2\",\"storage\":\"10\"},{\"projectName\":\"开发测试02\",\"projectPrefix\":\"kf_pro2\",\"databaseName\":\"kf_pro2_dws\"},{\"projectName\":\"开发测试02\",\"projectPrefix\":\"kf_pro2\",\"databaseName\":\"kf_pro2_ads\"}]");
	}
}
