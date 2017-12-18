package exjobb.cache.mongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jimmie on 12/18/2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
