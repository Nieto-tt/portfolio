package com.nietott.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class softskillsDTO {
    private Long softId;
    private Long userId;
    private String skillName;
    private String icon;

    public softskillsDTO(){}
}
