package com.stringcodeltd.studentapp.dao;

import com.stringcodeltd.studentapp.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<FAQ, Integer> {

}
