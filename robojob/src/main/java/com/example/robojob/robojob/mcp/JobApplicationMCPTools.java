package com.example.robojob.robojob.mcp;

import com.example.robojob.robojob.model.ApplicationStatus;
import com.example.robojob.robojob.model.JobApplication;
import com.example.robojob.robojob.service.JobApplicationService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobApplicationMCPTools {

    private final JobApplicationService service;

    public JobApplicationMCPTools(JobApplicationService jobApplicationService) {
        this.service = jobApplicationService;
    }

    @McpTool(
            name = "get_all_applications",
            description = "Return all the job applications"
    )
    public List<JobApplication> getJobApplications() {
        return service.getAllJobApplications();
    }

    @McpTool(
            name = "get_rejected_applications",
            description = "Returns all job applications that have been rejected"
    )
    public List<JobApplication> getRejectedApplications() {
        return service.getApplicationsByStatus(ApplicationStatus.REJECTED);
    }

    @McpTool(
            name = "get_pending_applications",
            description = "Returns all job applications that are still pending"
    )
    public List<JobApplication> getPendingApplications() {
        return service.getApplicationsByStatus(ApplicationStatus.ONGOING);
    }

    @McpTool(
            name = "get_applications_by_company",
            description = "Returns job applications for a specific company"
    )
    public List<JobApplication> getApplicationsByCompany(String company) {
        return service.getApplicationsByCompany(company);
    }
}
