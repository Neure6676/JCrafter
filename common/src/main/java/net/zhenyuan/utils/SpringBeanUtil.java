package net.zhenyuan.utils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SpringBeanUtil {

    /**
     * Copy properties from source to target
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> target) {
        try {
            T t = target.getConstructor().newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Copy properties of list from source to target
     * @param sourceList
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> copyProperties(List<?> sourceList , Class<T> target) {
        ArrayList<T> targetList = new ArrayList<>();
        sourceList.forEach(source -> {
            T t = copyProperties(source, target);
            targetList.add(t);
        });
        return targetList;
    }


}
