package com.ahamed.companyms.company.impl;

import com.ahamed.companyms.company.Company;
import com.ahamed.companyms.company.CompanyRepository;
import com.ahamed.companyms.company.CompanyService;
import com.ahamed.companyms.company.dto.ReviewMessage;
import com.ahamed.companyms.company.feignClient.ReviewClient;
import com.ahamed.companyms.company.messaging.ReviewMessageConsumer;
import feign.FeignException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient = reviewClient;
    }


    @Override
    public void updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyRepository.save(companyToUpdate);
        } else {
        }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompanyById(Long id) {
        Optional<Company> company=companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }
        else {
            throw new RuntimeException("Not found");
        }
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
     Company company=companyRepository.findById(reviewMessage.getCompanyId())
             .orElseThrow(()->
                     new NotFoundException(
                             "company not found :"+reviewMessage.getCompanyId()));
     Double averageRating=reviewClient.averageRating(reviewMessage.getCompanyId());
     company.setAverageRating(averageRating);
     companyRepository.save(company);

    }


}
