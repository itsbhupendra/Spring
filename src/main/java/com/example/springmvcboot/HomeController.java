package com.example.springmvcboot;

import com.example.springmvcboot.model.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {


    @ModelAttribute
    public void setName(ModelMap mp){
        mp.addAttribute("name","Welcome Back Aliens");

    }
    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("getAliens")
    public String showAlien(ModelMap  mp){
        List<Alien> aliens= Arrays.asList(new Alien(101,"ashu"),new Alien(102,"Bhupendra"));

        mp.addAttribute("alienList",aliens);
        return "showAlien";
    }

    @RequestMapping("calculate")
    public String add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, ModelMap mp){

//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("add");
        int num3=n1+n2;
        int num4=n1-n2;
        mp.addAttribute("num3",num3);
        mp.addAttribute("num4",num4);
//        int n1=Integer.parseInt(req.getParameter("num1"));
//        int n2=Integer.parseInt(req.getParameter("num2"));

//        int num3=n1+n2;
//        int num4=n1-n2;
//        HttpSession session= req.getSession();
//        modelAndView.addObject("num3",num3);
//        modelAndView.addObject("num4",num4);
//        session.setAttribute("num3",num3);
//        session.setAttribute("num4",num4);
//        return modelAndView;
        return "add";
    }

//    @RequestMapping("addAlien")
//    public String addAlien(@RequestParam("aName") String aName,@RequestParam("aId") int aId,ModelMap mp){
//        Alien alien = new Alien();
//        alien.setaId(aId);
//        alien.setaName(aName);
//
//        mp.addAttribute("alien",alien);
//        return "add";
//    }

    @RequestMapping("addAlien")
    public String addAlien(@ModelAttribute ("a1")Alien alien ){
//        mp.addAttribute("alien",alien);
        return "add";
    }
}
