package com.example.issuemanagement.service;


import com.example.issuemanagement.dto.ProjectDto;
import com.example.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Project project);


    ProjectDto update(Long id, ProjectDto projectDto);
}
