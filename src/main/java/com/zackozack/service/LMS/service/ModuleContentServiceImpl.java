package com.zackozack.service.LMS.service;

import com.zackozack.service.LMS.dto.ModuleContentDto;
import com.zackozack.service.LMS.entity.Course;
import com.zackozack.service.LMS.entity.CourseModule;
import com.zackozack.service.LMS.entity.ModuleContent;
import com.zackozack.service.LMS.exception.ResourceNotFoundException;
import com.zackozack.service.LMS.repository.CourseModuleRepository;
import com.zackozack.service.LMS.repository.ModuleContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModuleContentServiceImpl implements ModuleContentService {
    private final CourseModuleRepository courseModuleRepository;
    private final ModuleContentRepository moduleContentRepository;
    private final ModelMapper modelMapper;
    @Override
    public ModuleContentDto createNewModuleContent(Long moduleId, ModuleContentDto moduleContentDto) {
        log.info("Saving module content with title: {}", moduleContentDto.getTitle());
        CourseModule courseModule = courseModuleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Course module not found with id: " + moduleId));
        Course course = courseModule.getCourse();
        ModuleContent moduleContent = modelMapper.map(moduleContentDto, ModuleContent.class);
        moduleContent.setCourseModule(courseModule);
        moduleContent = moduleContentRepository.save(moduleContent);
        log.info("Module content saved with id: {}", moduleContent.getId());
        return modelMapper.map(moduleContent, ModuleContentDto.class);
    }

    @Override
    public ModuleContentDto getModuleContentById(Long moduleId, Long id) {
        log.info("Fetching module content with id: {}", id);
        CourseModule courseModule = courseModuleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Course module not found with id: " + moduleId));
        Course course = courseModule.getCourse();
        ModuleContent moduleContent = moduleContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module content not found with id: " + id));
        return modelMapper.map(moduleContent, ModuleContentDto.class);
    }

    @Override
    public ModuleContentDto updateModuleContent(Long moduleId, Long id, ModuleContentDto moduleContentDto) {
        log.info("Updating module content with id: {}", id);
        CourseModule courseModule = courseModuleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Course module not found with id: " + moduleId));
        Course course = courseModule.getCourse();
        ModuleContent moduleContent = moduleContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module content not found with id: " + id));
        mapDTOToEntity(moduleContentDto, moduleContent);
        moduleContent = moduleContentRepository.save(moduleContent);
        log.info("Module content updated with id: {}", moduleContent.getId());
        return modelMapper.map(moduleContent, ModuleContentDto.class);
    }

    @Override
    public Boolean deleteModuleContent(Long moduleId, Long id) {
        log.info("Deleting module content with id: {}", id);
        CourseModule courseModule = courseModuleRepository.findById(moduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Course module not found with id: " + moduleId));
        Course course = courseModule.getCourse();
        ModuleContent moduleContent = moduleContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module content not found with id: " + id));
        moduleContentRepository.delete(moduleContent);
        log.info("Module content deleted with id: {}", id);
        return true;
    }

    public void mapDTOToEntity(ModuleContentDto moduleContentDto, ModuleContent moduleContent) {
        moduleContent.setTitle(moduleContentDto.getTitle());
        moduleContent.setDescription(moduleContentDto.getDescription());
        moduleContent.setContentType(moduleContentDto.getContentType());
        moduleContent.setContentUrl(moduleContentDto.getContentUrl());
    }
}
