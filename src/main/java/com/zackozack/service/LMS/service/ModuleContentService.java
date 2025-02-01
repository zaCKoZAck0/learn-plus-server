package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.ModuleContentDto;

public interface ModuleContentService {
    ModuleContentDto createNewModuleContent(Long moduleId, ModuleContentDto moduleContentDto);
    ModuleContentDto getModuleContentById(Long id);
    ModuleContentDto updateModuleContent(Long id, ModuleContentDto moduleContentDto);
    Boolean deleteModuleContent(Long id);
}
