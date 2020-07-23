package com.example.issuemanagement.service.impl;

import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.entity.Project;
import com.example.issuemanagement.repository.ProjectRepository;
import com.example.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository; //inject
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        Project p = modelMapper.map(projectDto, Project.class);
        p = projectRepository.save(p);
        projectDto.setId(p.getId());

        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);

        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null) {
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);
        }

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);

        if (projectCheck != null ) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        projectDb.setProjectCode(projectDto.getProjectCode());
        projectDb.setProjectName(projectDto.getProjectName());
        projectRepository.save(projectDb);

        return modelMapper.map(projectDb, ProjectDto.class);
    }
}
