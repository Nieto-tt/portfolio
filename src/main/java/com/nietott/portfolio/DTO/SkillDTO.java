package com.nietott.portfolio.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SkillDTO implements Serializable {
    private int skillId;
    private int userId;
    private String skillName;
    private String proficiencyLevel;
    private String icon;

    public SkillDTO(){}
}
