package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class HomeController {
    @Autowired
    ActivityRepository activityRepository;
    @RequestMapping("/")
    public String listActivities(Model model){
        model.addAttribute("activities", activityRepository.findAll());
        return "list";
        }
        @GetMapping("/add")
    public String  listActivites (Model model){
        model.addAttribute("activity", new Activity());
        return "error";

        }
  /*
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("activity")Activity activity, BindingResult result)
        {
            if (result.hasErrors()){
            return "error";
        }
        activityRepository.save(activity);
       return "redirect:/";
        }*/

  @PostMapping("/process")
  public String processForm(@Valid Activity activity, BindingResult result)
  {
      if(result.hasErrors()){return "error";}

      activityRepository.save(activity);
      return "redirect:/";
  }


        @RequestMapping("/update/{id}")
public String updateActivity(@PathVariable("id") long id, Model model)
        {model.addAttribute("activity", activityRepository.findById(id). get());
        return "error";
        }
        @RequestMapping("/delete/{id}")
        public String delActivity(@PathVariable("id") long id, Model model)
        {model.addAttribute("activiy", activityRepository.findById(id). get());
            return "redirect:/";
        }
        @RequestMapping("/testbootstrap")
    public String showIndex(){return "index";
    }


}
