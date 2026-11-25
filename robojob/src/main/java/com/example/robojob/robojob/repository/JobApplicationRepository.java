package com.example.robojob.robojob.repository;

import com.example.robojob.robojob.model.ApplicationStatus;
import com.example.robojob.robojob.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findBySource(ApplicationStatus source);
    List<JobApplication> findByCompanyIgnoreCase(String company);
}
