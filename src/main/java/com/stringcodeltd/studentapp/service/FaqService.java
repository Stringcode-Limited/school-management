package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.FaqRepository;
import com.stringcodeltd.studentapp.model.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqService {

    @Autowired
    private FaqRepository faqrepo;

    public FAQ createFAQ(FAQ faq){
        return faqrepo.save(faq);
    }

    public List<FAQ> getAllFAQs(){
        return faqrepo.findAll();
    }

    public String updateFAQ(FAQ faq, int faqID){
        if (faqrepo.existsById(faqID)){
            FAQ newFAQ = faqrepo.findById(faqID).get();

            newFAQ.setQuestion(faq.getQuestion());
            newFAQ.setAnswer(faq.getAnswer());

            faqrepo.save(newFAQ);
            return "FAQ with id " + faqID + " updated successfully";
        }
        return "FAQ with id " +faqID + " does not exist";
    }

    public String deleteFAQ(Integer faqID){
        if(faqrepo.existsById(faqID)){
            faqrepo.deleteById(faqID);
            return "FAQ with id " + faqID + " has been deleted successfully";
        }
        return "FAQ with id " + faqID + " does not exist";
    }

    public Optional<FAQ> getSpecificQuestion(int faqId) {
        if(faqrepo.existsById(faqId)){
           return faqrepo.findById(faqId);
        }
        return null;
    }
}