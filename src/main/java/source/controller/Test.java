package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Test {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test() {
        return "test";
    }
}
