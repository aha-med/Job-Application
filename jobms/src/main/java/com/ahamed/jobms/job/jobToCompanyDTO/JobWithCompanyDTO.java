package com.ahamed.jobms.job.jobToCompanyDTO;

import com.ahamed.jobms.job.external.Company;
import com.ahamed.jobms.job.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobWithCompanyDTO {
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> review;
}
