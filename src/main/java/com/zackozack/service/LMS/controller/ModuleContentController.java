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
        ModuleContentDto newModuleContent = moduleContentService.createNewModuleContent(moduleId, moduleContentDto);
        return new ResponseEntity<>(newModuleContent, HttpStatus.CREATED);
    }
    @GetMapping("/{moduleId}/contents/{id}")
    public ResponseEntity<ModuleContentDto> getModuleContentById(@PathVariable Long moduleId, @PathVariable Long id) {
        ModuleContentDto moduleContentDto = moduleContentService.getModuleContentById(moduleId, id);
        return new ResponseEntity<>(moduleContentDto, HttpStatus.OK);
    }
    @PutMapping("/{moduleId}/contents/{id}")
    public ResponseEntity<ModuleContentDto> updateModuleContent(@PathVariable Long moduleId, @PathVariable Long id, @RequestBody ModuleContentDto moduleContentDto) {
        ModuleContentDto updatedModuleContent = moduleContentService.updateModuleContent(moduleId, id, moduleContentDto);
        return new ResponseEntity<>(updatedModuleContent, HttpStatus.OK);
    }
    @DeleteMapping("/{moduleId}/contents/{id}")
    public ResponseEntity<Boolean> deleteModuleContent(@PathVariable Long moduleId, @PathVariable Long id) {
        Boolean isDeleted = moduleContentService.deleteModuleContent(moduleId, id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
