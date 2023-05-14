package com.nietott.portfolio.service;

import com.nietott.portfolio.DTO.certificationsDTO;

public interface ICertificationService {
    public void newCertification(certificationsDTO edu);
    
    public boolean editCertification(Long id, certificationsDTO edu);
    
    public void deleteCertification(Long id);
}
