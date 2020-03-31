package yang.udf.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 杨冲  (E0236)
 * @create: 2019-12-05 17:20
 */
public class EBPPlatformOverview extends UDF {

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: 杨冲  (E0236)
     * @date: 2019/12/5 17:29
     */
    /*
    [
    {
        "projectName": "开发测试02",
        "projectPrefix": "kf_pro2",
        "databaseName": "kf_pro2_ods",
        "tableName": "test_student_ods",
        "storage": "0"
    },
    {
        "projectName": "开发测试02",
        "projectPrefix": "kf_pro2",
        "databaseName": "kf_pro2_dwd",
        "tableName": "test_student_dwd",
        "storage": "0"
    },
    {
        "projectName": "开发测试02",
        "projectPrefix": "kf_pro2",
        "databaseName": "kf_pro2_dwd",
        "tableName": "test_student_dwd2",
        "storage": "10"
    },
    {
        "projectName": "开发测试02",
        "projectPrefix": "kf_pro2",
        "databaseName": "kf_pro2_dws"
    },
    {
        "projectName": "开发测试02",
        "projectPrefix": "kf_pro2",
        "databaseName": "kf_pro2_ads"
    }
]
    */
    public String evaluate(String input) {
        StringBuffer values = new StringBuffer();


        // 如果传进来的数据为空，直接返回过滤掉该数据
        if (StringUtils.isBlank(input)) {
            return null;
        } else {
            List<Map<String, String>> tableList = JSON.parseObject(input, new TypeReference<List<Map<String, String>>>() {
            });
            for (Map<String, String> map : tableList) {

                if (StringUtils.isNotBlank(map.get("projectName"))) {
                    values.append(map.get("projectName"));
                }
                if (StringUtils.isNotBlank(map.get("projectPrefix"))) {
                    values.append("," + map.get("projectPrefix"));
                }
                if (StringUtils.isNotBlank(map.get("databaseName"))) {
                    values.append("," + map.get("databaseName"));
                }else {
                    values.append(",");
                }
                if (StringUtils.isNotBlank(map.get("tableName"))) {
                    values.append("," + map.get("tableName"));
                }else {
                    values.append(",");
                }
                if (StringUtils.isNotBlank(map.get("storage"))) {
                    values.append("," + map.get("storage"));
                }else {
                    values.append(",");
                }
                values.append(";");

            }


        }
        String substring = values.substring(0, values.length() - 1);

        System.out.println(substring);
        return substring;

    }

}
