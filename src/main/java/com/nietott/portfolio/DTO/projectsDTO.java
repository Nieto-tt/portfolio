package com.nietott.portfolio.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class projectsDTO {
    private Long projectId;
    private Long userId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String imageUrl;
    private String liveUrl;

    public projectsDTO(){}
}
