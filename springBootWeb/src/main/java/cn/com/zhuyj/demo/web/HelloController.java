package cn.com.zhuyj.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//    @RequestMapping(value="/hello")
//    public String index() {
//        return "Hello World!";
//    }

    /**
     * 开发web应用，使用模版引擎
     * @param model
     * @return
     */
//    @RequestMapping("/")
//    public String index(Model model) {
// 加⼊⼀个属性，⽤来在模板中读取
//        model.addAttribute("host", "http://www.baidu.com");
// return模板⽂件的名称，对应src/main/resources/templates/index.html
//        return "index";
//    }


    /**
     * 使用spring-security进行安全控制
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        return "index-security";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


}
