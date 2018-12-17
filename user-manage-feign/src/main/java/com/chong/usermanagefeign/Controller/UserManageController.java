package com.chong.usermanagefeign.Controller;

import com.chong.puttycommon.po.User;
import com.chong.usermanagefeign.service.RefactorUserManageService;
import com.chong.usermanagefeign.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RefreshScope       //通过/bus/refresh,实现配置动态刷新
@Controller
public class UserManageController {

    @Autowired
    UserManageService userManageService;
    @Autowired
    RefactorUserManageService refactorUserManageService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloConsumer() {
        return userManageService.hello();
    }
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(userManageService.hello()).append("\n").
                append(userManageService.hello("chong")).append("\n").
                append(userManageService.hello(new User(1,"chong"))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorUserManageService.hello("LI")).append("\n").
                append(refactorUserManageService.hello(new com.chong.userapi.po.User(0,"LI"))).append("\n");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/word")
    public String word() {
        return "word";
    }

    @GetMapping(value = "/words")
    public String words(Model model) {
        List<Word> list = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            list.add(new Word("hello"+i,"gg"));
        }
        model.addAttribute("wordList",list);
        return "word::content";
    }

    /*@Value("${author}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return from;
    }*/
}
