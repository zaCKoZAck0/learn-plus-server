package com.zackozack.service.LMS.controller;

import com.zackozack.service.LMS.dto.ModuleContentDto;
import com.zackozack.service.LMS.service.ModuleContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/modules")
@RequiredArgsConstructor
public class ModuleContentController {
    private final ModuleContentService moduleContentService;
    @PostMapping("/{moduleId}/contents")
    public ResponseEntity<ModuleContentDto> saveModuleContent(@PathVariable Long moduleId, @RequestBody ModuleContentDto moduleContentDto) {
        ModuleContentDto newModuleContent = moduleContentService.save(moduleId, moduleContentDto);
        return new ResponseEntity<>(newModuleContent, HttpStatus.CREATED);
    }
}
