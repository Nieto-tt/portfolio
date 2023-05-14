package com.nietott.portfolio.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class experienceDTO {
    private Long expId;
    private Long userId;
    private String companyName;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String jobDescription;
    private String imageUrl;

    public experienceDTO(){}
}
