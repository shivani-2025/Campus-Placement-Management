package com.example.campusplacement.mapper;

import com.example.campusplacement.dto.CollegeDTO;
import com.example.campusplacement.entity.College;

import java.util.ArrayList;
import java.util.List;

public class CollegeMapper {

    // ----------------------------
    // Entity → DTO (Single object)
    // ----------------------------
    public static CollegeDTO toDTO(College college) {
        if (college == null) return null;

        CollegeDTO dto = new CollegeDTO();
        dto.setCollegeId(college.getCollegeId());
        dto.setName(college.getName());
        dto.setLocation(college.getLocation());
        dto.setTier(college.getTier());
        return dto;
    }

    // --------------------------------------
    // DTO → Entity (Single object)
    // ID not set because database generates it
    // --------------------------------------
    public static College toEntity(CollegeDTO dto) {
        if (dto == null) return null;

        College college = new College();
        college.setName(dto.getName());
        college.setLocation(dto.getLocation());
        college.setTier(dto.getTier());
        return college;
    }

    // ----------------------------
    // Entity List → DTO List
    // ----------------------------
    public static List<CollegeDTO> toDTOList(List<College> colleges) {
        List<CollegeDTO> dtoList = new ArrayList<>();
        if (colleges == null) return dtoList;

        for (College college : colleges) {
            dtoList.add(toDTO(college));
        }
        return dtoList;
    }

    // ----------------------------
    // DTO List → Entity List
    // ----------------------------
    public static List<College> toEntityList(List<CollegeDTO> dtoList) {
        List<College> entities = new ArrayList<>();
        if (dtoList == null) return entities;

        for (CollegeDTO dto : dtoList) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
