package cn.com.zhuyj.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//    @RequestMapping(value="/hello")
//    public String index() {
//        return "Hello World!";
//    }


    @RequestMapping("/")
    public String index(Model model) {
// 加⼊⼀个属性，⽤来在模板中读取
        model.addAttribute("host", "http://www.baidu.com");
// return模板⽂件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
