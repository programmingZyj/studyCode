package cn.com.zhuyj.demo;

import cn.com.zhuyj.demo.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class DemoApplicationTests {

    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void testUserController() throws Exception {
// 测试UserController
        RequestBuilder request = null;
// 1、get查⼀下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(("[]")));
// 2、post提交⼀个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试⼤师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(("success")));
// 3、get获取user列表，应该有刚才插⼊的数据
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(("[{\"id\":1,\"name\":\"测试⼤师\",\"age\":20}]")));
// 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "测试终极⼤师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(("success")));
// 5、get⼀个id为1的user
//        request = get("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(("{\"id\":1,\"name\":\"测试终极⼤开发RESTful接⼝服务及单元测试\",\"age\":30}")));
// 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string("success"));
// 7、get查⼀下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(("[]")));


        System.out.println("-----------------asdasdasdasdasd--------");
    }


}
