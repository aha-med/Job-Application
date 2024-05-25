package com.ahamed.jobms.job.impl;

import com.ahamed.jobms.job.external.Company;
import com.ahamed.jobms.job.external.Review;
import com.ahamed.jobms.job.Job;
import com.ahamed.jobms.job.JobRepository;
import com.ahamed.jobms.job.JobService;
import com.ahamed.jobms.job.client.CompanyClient;
import com.ahamed.jobms.job.client.ReviewClient;
import com.ahamed.jobms.job.mapper.JobWithCompanyMapper;
import com.ahamed.jobms.job.jobToCompanyDTO.JobWithCompanyDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    int attempt=0;
    JobRepository jobRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private  CompanyClient companyClient;
    @Autowired
    private ReviewClient reviewClient;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;

    }

    @Override
//    @CircuitBreaker(name="companyBreaker",fallbackMethod = "fallingMethod")
    @Retry(name="companyBreaker",fallbackMethod = "fallingMethod")
    public List<JobWithCompanyDTO> findAll() {
        System.out.println("attemp :"+  ++attempt);
        List<Job> jobs=jobRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public JobWithCompanyDTO convertToDTO(Job job){
//        Company company=restTemplate
//                .getForObject("http://COMPANY-SERVICE:8083/companies/" +
//                                job.getCompanyId(),
//                                Company.class);
//        ResponseEntity<List<Review>> reviewsResponse=restTemplate
//                .exchange("http://REVIEWS-SERVICES:8082/reviews?companyId=" + job.getCompanyId(),
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<Review>>() {
//                        });
//        List<Review> reviews=reviewsResponse.getBody();
          List<Review> reviews=reviewClient.getReviews(job.getCompanyId());
        Company company=companyClient.getCompany(job.getCompanyId());
        return JobWithCompanyMapper.map(job,company,reviews);
    }
    public List<String> fallingMethod(Exception e){

        return new ArrayList<>(List.of("dummy"));
    }


    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO getJobById(Long id) {
        Job job=jobRepository.findById(id).orElse(null);
        assert job != null;
        return convertToDTO(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}