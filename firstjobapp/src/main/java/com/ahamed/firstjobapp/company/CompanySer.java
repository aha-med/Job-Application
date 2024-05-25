package com.ahamed.firstjobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanySer {
    private final CompanyRepo companyRepo;
    CompanySer(CompanyRepo companyRepo){
        this.companyRepo=companyRepo;
    }
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }

    public Company getCompanyById(Long id) {
      Optional<Company> company=companyRepo.findById(id);
      if(company.isPresent()){
          return company.get();
      }
      else {
          throw new RuntimeException("Not found");
      }
    }

    public Boolean updateCompany(Long id, Company company) {

        Optional<Company> option=companyRepo.findById(id);
        if(option.isPresent()) {
            Company actualCompany = option.get();
            actualCompany.setDescription(company.getDescription());
            actualCompany.setName(company.getName());
            actualCompany.setJobs(company.getJobs());
            companyRepo.save(actualCompany);
            return true;
        }
        else{
             return false;
        }

    }

    public void deleteById(Long id) {
        companyRepo.deleteById(id);
    }
}
