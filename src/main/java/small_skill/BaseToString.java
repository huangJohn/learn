package small_skill;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuanghuang
 * @date 2018/6/19
 */

public class BaseToString {

    @Override
    public String toString() {

        Class<?> entityClass = this.getClass();
        List<String> fieldHiddens = new ArrayList<>();
        while (entityClass != ToString.class && entityClass != Object.class) {
            for (Field f : entityClass.getDeclaredFields()) {
                if (null != f.getAnnotation(StringHidden.class)) {
                    fieldHiddens.add(f.getName());
                }
            }
            entityClass = entityClass.getSuperclass();
        }
        if (CollectionUtils.isEmpty(fieldHiddens)) {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .setExcludeFieldNames(fieldHiddens.toArray(new String[fieldHiddens.size()])).toString();
    }
}
