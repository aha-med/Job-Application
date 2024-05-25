package com.ahamed.jobms.job.mapper;


import com.ahamed.jobms.job.external.Company;
import com.ahamed.jobms.job.external.Review;
import com.ahamed.jobms.job.Job;
import com.ahamed.jobms.job.jobToCompanyDTO.JobWithCompanyDTO;


import java.util.List;

public class JobWithCompanyMapper {
    public static JobWithCompanyDTO map(Job job, Company company, List<Review> reviews){
        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReview(reviews);
        return jobWithCompanyDTO;
    }
}
