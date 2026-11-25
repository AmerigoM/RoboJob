package com.example.robojob.robojob.service;

import com.example.robojob.robojob.exception.JobApplicationNotFoundException;
import com.example.robojob.robojob.model.ApplicationStatus;
import com.example.robojob.robojob.model.JobApplication;
import com.example.robojob.robojob.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllJobApplications(){
        return repository.findAll();
    }

    public JobApplication addJobApplication(JobApplication jobApplication){
        return repository.save(jobApplication);
    }

    public JobApplication updateJobApplication(Long id, JobApplication jobApplication){
        if (!repository.existsById(id)) {
            throw new JobApplicationNotFoundException(id);
        }

        jobApplication.setId(id);

        return repository.save(jobApplication);
    }

    public void deleteJobApplication(Long id){
        if (!repository.existsById(id)) {
            throw new JobApplicationNotFoundException(id);
        }

        repository.deleteById(id);
    }

    public List<JobApplication> getApplicationsByStatus(ApplicationStatus applicationStatus) {
        return repository.findBySource(applicationStatus);
    }

    public List<JobApplication> getApplicationsByCompany(String company) {
        return repository.findByCompanyIgnoreCase(company);
    }
}
