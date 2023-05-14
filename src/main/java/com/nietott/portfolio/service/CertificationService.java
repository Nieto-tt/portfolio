package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.certificationsDTO;
import com.nietott.portfolio.model.Certifications;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.CertificationsRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class CertificationService implements ICertificationService{

    @Autowired public CertificationsRepository certificationsRepository;
    @Autowired public UserRepository userRepository;

    @Override
    public void deleteCertification(Long id) {
        certificationsRepository.deleteById(id);
    }

    @Override
    public boolean editCertification(Long id, certificationsDTO certifications) {
        if (!certificationsRepository.existsById(id)) {
            return false;
        } else {
            Certifications certificationsEdited = certificationsRepository.findById(id).orElse(null);
            certificationsEdited.setUsers(userRepository.findById(certifications.getUserId()).orElse(null));
            certificationsEdited.setCertificationName(certifications.getCertificationName());
            certificationsEdited.setInstitutionName(certifications.getInstitutionName());
            certificationsEdited.setDateObtained(certifications.getDateObtained());
            certificationsEdited.setCertificationUrl(certifications.getCertificationUrl());
            certificationsEdited.setImageUrl(certifications.getImageUrl());

            certificationsRepository.save(certificationsEdited);
            return true;
        }
    }

    @Override
    public void newCertification(certificationsDTO certifications) {
        Users users = userRepository.findById(certifications.getUserId()).orElse(null);
        Certifications newcertifications = new Certifications(
            certifications.getCertId(),
            users, 
            certifications.getCertificationName(), 
            certifications.getInstitutionName(), 
            certifications.getDateObtained(), 
            certifications.getCertificationUrl(), 
            certifications.getImageUrl());
            
        certificationsRepository.save(newcertifications);
    }
    
}
