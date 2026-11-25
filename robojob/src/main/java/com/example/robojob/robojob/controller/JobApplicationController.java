package com.example.robojob.robojob.controller;

import com.example.robojob.robojob.model.JobApplication;
import com.example.robojob.robojob.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobService;

    @GetMapping("jobApplications")
    public ResponseEntity<List<JobApplication>> getAllJobApplication() {
        return ResponseEntity
                .ok()
                .body(jobService.getAllJobApplications());
    }

    @PostMapping("jobApplication")
    public ResponseEntity<JobApplication> addJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication returnedApplication = jobService.addJobApplication(jobApplication);

        return ResponseEntity
                .created(URI.create("/jobApplication/" + returnedApplication.getId()))
                .body(returnedApplication);
    }

    @PutMapping("jobApplication/{id}")
    public ResponseEntity<JobApplication> updateJobApplication(
            @PathVariable Long id,
            @RequestPart JobApplication jobApplication
    ) {
        JobApplication returnedApplication = jobService.updateJobApplication(id, jobApplication);

        return ResponseEntity
                .ok()
                .body(returnedApplication);
    }

    @DeleteMapping("jobApplications/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
        jobService.deleteJobApplication(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
