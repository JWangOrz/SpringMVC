package hello;

//import hello.testService;
import hello.Test;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.view.RedirectView;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController 
{

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) 
    {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    //private testService visitor;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testForm( Model model)
    {
    	model.addAttribute("test", new Test());
    	//model.addAttribute("test", visitor.listVisitor());
    	return "test";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testSubmit(@ModelAttribute Test test, Model model)
    {
    	model.addAttribute("test", test);
    	return "result";
    }
}
