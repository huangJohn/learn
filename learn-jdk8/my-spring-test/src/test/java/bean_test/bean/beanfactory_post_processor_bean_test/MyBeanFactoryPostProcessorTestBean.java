package bean_test.bean.beanfactory_post_processor_bean_test;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */

@Data
@ToString
@Accessors(chain = true)
public class MyBeanFactoryPostProcessorTestBean {

    private String name;

}
