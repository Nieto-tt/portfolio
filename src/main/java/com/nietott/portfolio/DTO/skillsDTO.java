package com.nietott.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class skillsDTO {
    private int skillId;
    private int userId;
    private String skillName;
    private String proficiencyLevel;
    private String icon;

    public skillsDTO(){}
}
