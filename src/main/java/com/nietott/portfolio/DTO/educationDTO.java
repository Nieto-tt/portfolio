package com.nietott.portfolio.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class educationDTO {
    private Long eduId;
    private Long userId;
    private String institutionName;
    private String degreeName;
    private String fieldOfStudy;
    private Date startDate;
    private Date endDate;
    private String imageUrl;

    public educationDTO(){}
}
