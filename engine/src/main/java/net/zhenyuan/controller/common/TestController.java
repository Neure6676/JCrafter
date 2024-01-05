package net.zhenyuan.controller.common;

import cn.hutool.core.util.RandomUtil;
import jakarta.servlet.http.HttpServletResponse;
import net.zhenyuan.utils.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class TestController {

    /**
     * Login with form
     * @param mail
     * @param pwd
     * @return
     */
    @RequestMapping("/api/v1/test/login_form")
    @ResponseBody
    public JsonData login(String mail, String pwd) {

        if (mail.startsWith("a")) {
            return JsonData.buildError("Account does not exist");
        }

        return JsonData.buildSuccess("Login successful");
    }

    @PostMapping("/api/v1/test/pay_json")
    @ResponseBody
    public JsonData pay(@RequestBody Map<String,String> map) {

        String id = map.get("id");
        String amount = map.get("amount");
        return JsonData.buildSuccess("id="+id+",amount="+amount);
    }

    @PostMapping("/api/v1/test/pay_json_sleep")
    @ResponseBody
    public JsonData paySleep(@RequestBody Map<String,String> map) {

        try {
            int value = RandomUtil.randomInt(1000);
            TimeUnit.MICROSECONDS.sleep(value);
            String id = map.get("id");
            String amount = map.get("amount");
            return JsonData.buildSuccess("id="+id+",amount="+amount+",sleep="+value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/api/v1/test/query")
    @ResponseBody
    public JsonData queryDetail(Long id){
        return JsonData.buildSuccess("id="+id);
    }


    @GetMapping("/api/v1/test/query_sleep")
    @ResponseBody
    public JsonData querySleep(Long id){
        try {
            int value = RandomUtil.randomInt(1000);
            TimeUnit.MICROSECONDS.sleep(value);
            return JsonData.buildSuccess("id="+id+",sleep="+value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/api/v1/test/query_error_code")
    @ResponseBody
    public JsonData queryError(Long id,  HttpServletResponse response){

        if(id % 3 == 0){
            response.setStatus(500);
        }
        return JsonData.buildSuccess("id="+id);
    }

}
