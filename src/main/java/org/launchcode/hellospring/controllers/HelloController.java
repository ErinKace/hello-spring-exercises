package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form hello?name=LaunchCode
    @RequestMapping(value="hello", method={RequestMethod.GET,RequestMethod.POST})
    public String helloWithQuery(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    // handles requests of the form hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='message' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='select' name='language'>" +
                "<option value=''>--Select--</option>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='japanese'>Japanese</option>" +
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    @GetMapping("message")
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        HashMap<String,String> languageOptions = new HashMap<>();
        languageOptions.put("english","Hello, ");
        languageOptions.put("french","Bonjour, ");
        languageOptions.put("german","Guten Tag, ");
        languageOptions.put("spanish", "Buenos dias, ");
        languageOptions.put("japanese","Konnichiwa");
        return languageOptions.get(language)+name+"!";
    }
}
