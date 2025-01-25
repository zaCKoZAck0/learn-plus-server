package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.ModuleContentDto;

public interface ModuleContentService {
    ModuleContentDto save(Long moduleId, ModuleContentDto moduleContentDto);
}
