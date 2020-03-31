package yang.udaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.AbstractGenericUDAFResolver;
import org.apache.hadoop.io.FloatWritable;

/**
 * @description:
 * @author: 杨冲  (E0236)
 * @create: 2019-11-22 16:23
 */
public class MaxNumber extends AbstractGenericUDAFResolver {
    public static class MaxiNumberIntUDAFEvaluator implements UDAFEvaluator {
        //最终结果
        private FloatWritable result;
        //负责初始化计算函数并设置它的内部状态，result是存放最终结果的
        @Override
        public void init() {
            result=null;
        }
        //每次对一个新值进行聚集计算都会调用iterate方法
        public boolean iterate(FloatWritable value)
        {
            if(value==null) {
                return false;
            }
            if(result==null) {
                result=new FloatWritable(value.get());
            } else {
                result.set(Math.max(result.get(), value.get()));
            }
            return true;
        }

        //Hive需要部分聚集结果的时候会调用该方法
        //会返回一个封装了聚集计算当前状态的对象
        public FloatWritable terminatePartial()
        {
            return result;
        }
        //合并两个部分聚集值会调用这个方法
        public boolean merge(FloatWritable other)
        {
            return iterate(other);
        }
        //Hive需要最终聚集结果时候会调用该方法
        public FloatWritable terminate()
        {
            return result;
        }
    }
}
