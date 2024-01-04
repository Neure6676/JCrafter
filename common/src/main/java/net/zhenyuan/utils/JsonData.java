package net.zhenyuan.utils;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.zhenyuan.enums.BizCodeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {

    /**
     * bizStatusCode
     * 0 : success
     */
    private Integer code;

    /**
     * data
     */
    private Object data;

    /**
     * message
     */
    private String msg;

    /**
     *  get remote data
     *
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T getData(Class<T> typeReference){
        return JSON.parseObject(JSON.toJSONString(data),typeReference);
    }

    /**
     * success without data
     * @return
     */
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    /**
     *  success with data
     * @param data
     * @return
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    /**
     * failed with msg
     * @param msg
     * @return
     */
    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    /**
     * status code and error msg
     * @param code
     * @param msg
     * @return
     */
    public static JsonData buildCodeAndMsg(int code, String msg) {
        return new JsonData(code, null, msg);
    }

    /**
     * status code and error msg
     * @param codeEnum
     * @return
     */
    public static JsonData buildResult(BizCodeEnum codeEnum){
        return JsonData.buildCodeAndMsg(codeEnum.getCode(),codeEnum.getMessage());
    }

    public  boolean isSuccess(){
        return code == 0;
    }
}
