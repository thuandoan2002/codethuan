package com.trungtamjava.master.hellospring.controller;

import com.trungtamjava.master.hellospring.Laptop;
import com.trungtamjava.master.hellospring.PersonRepo;
import com.trungtamjava.master.hellospring.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    List<Person> persons = new ArrayList<>();
    @GetMapping("/create")
    public String create() {

        return "person/create.html";
    }
    @Autowired
    PersonRepo personRepo;
    @Autowired
    Laptop laptop;
    @Autowired
    PersonService personService;




    @PostMapping("/create")
    public ModelAndView create(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("age") int age,
            HttpServletRequest req, ModelAndView model) {

        //  String id = req.getInitParameter("id");
        Person p = new Person();
//        p.setId(id);
        p.setName(name);
        p.setAge(age);

        persons.add(p);
        // save to db
        personRepo.save(p);
         model.addObject("person", p);
        model.setViewName("/person/detail.html");
        return model;

    }
    @GetMapping("/detail")
    public String list(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("list", persons);
        return "person/detail.html";
    }

    @GetMapping("/search")
    public String search(@RequestParam("min") int min, @RequestParam("max") int max,
                         @RequestParam("page") int page, @RequestParam("size") int size, Model model){
        Page<Person> personPage =
                (Page<Person>) personRepo.search(min, max, PageRequest.of(page, size));
        System.out.println(personPage.getTotalPages());
        System.out.println(personPage.getNumberOfElements());
        model.addAttribute("list", personPage.getContent());
        return "redirect:/person/list";
    };

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        personRepo.deleteById(id);

        return "redirect:/person/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       Model model) {
       Person p = personRepo.findById(id).orElse(null);
       model.addAttribute("person", p);
        return "redirect:/person/edit.html";
    }
}


