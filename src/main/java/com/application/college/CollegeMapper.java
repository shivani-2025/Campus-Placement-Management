package com.application.college;

/**
 * Small utility mapper. Not strictly required if you work with entities directly.
 * If you want DTOs later, implement DTO classes and expand this mapper.
 */
public class CollegeMapper {

    public static CollegeDTO toDTO(College college) {
        if (college == null) return null;
        CollegeDTO dto = new CollegeDTO();
        dto.setId(college.getId());
        dto.setName(college.getName());
        dto.setLocation(college.getLocation());
        dto.setTier(college.getTier());
        return dto;
    }

    public static College toEntity(CollegeDTO dto) {
        if (dto == null) return null;
        College college = new College();
        college.setId(dto.getId());
        college.setName(dto.getName());
        college.setLocation(dto.getLocation());
        college.setTier(dto.getTier());
        return college;
    }

    // Simple DTO defined as package-private class in same file
    public static class CollegeDTO {
        private Integer id;
        private String name;
        private String location;
        private Integer tier;

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }

        public Integer getTier() { return tier; }
        public void setTier(Integer tier) { this.tier = tier; }
    }
}
