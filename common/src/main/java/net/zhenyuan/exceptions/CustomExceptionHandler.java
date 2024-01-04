package net.zhenyuan.exceptions;

import lombok.extern.slf4j.Slf4j;
import net.zhenyuan.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){

        if(e instanceof BizException bizException){
            log.error("[biz exception]{}",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMsg());
        }else {
            log.error("[system exception]{}",e);
            return JsonData.buildError("系统异常");
        }

    }

}