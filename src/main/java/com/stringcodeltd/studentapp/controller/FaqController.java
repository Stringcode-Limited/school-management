package com.stringcodeltd.studentapp.controller;


import com.stringcodeltd.studentapp.model.FAQ;
import com.stringcodeltd.studentapp.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/faq")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @PostMapping()
    public FAQ createFAQ(@Valid @RequestBody FAQ faq){
        return faqService.createFAQ(faq);
    }

    @GetMapping()
    public List<FAQ> getAllFAQs(){
        return faqService.getAllFAQs();
    }
    @GetMapping("/id")
    public Optional<FAQ> getSpecificFaq(@PathVariable(name="id") int faqId){
        return faqService.getSpecificQuestion(faqId);
    }
    @PutMapping("/update/{id}")
    public String editFAQ(@RequestBody FAQ faq, @PathVariable(name = "id") int faqID){
        return faqService.updateFAQ(faq, faqID);
    }

    @DeleteMapping("/{id}")
    public String deleteFAQ(@PathVariable(name = "id") int faqID){
        return faqService.deleteFAQ(faqID);
    }
}
