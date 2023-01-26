package com.stringcodeltd.studentapp.controller;


import com.stringcodeltd.studentapp.model.FAQ;
import com.stringcodeltd.studentapp.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PutMapping("/update/{id}")
    public String editFAQ(@RequestBody FAQ faq, @PathVariable(name = "id") int faqID){
        return faqService.updateFAQ(faq, faqID);
    }

    @DeleteMapping("/{id}")
    public String deleteFAQ(@PathVariable(name = "id") int faqID){
        return faqService.deleteFAQ(faqID);
    }
}
