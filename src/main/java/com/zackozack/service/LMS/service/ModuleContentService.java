package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.ModuleContentDto;

public interface ModuleContentService {
    ModuleContentDto createNewModuleContent(Long moduleId, ModuleContentDto moduleContentDto);
    ModuleContentDto getModuleContentById(Long moduleId, Long id);
    ModuleContentDto updateModuleContent(Long moduleId, Long id, ModuleContentDto moduleContentDto);
    Boolean deleteModuleContent(Long moduleId, Long id);
}
