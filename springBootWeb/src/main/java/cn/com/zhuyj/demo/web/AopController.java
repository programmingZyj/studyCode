package cn.com.zhuyj.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * SpringAop
 */
@Controller
public class AopController {

    @ResponseBody
    @RequestMapping(value = "aop", method = RequestMethod.GET)
    public String aop(@RequestParam String name){
        return "aop"+name;
    }
}
