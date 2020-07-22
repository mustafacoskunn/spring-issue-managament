package com.example.issuemanagement.service;

import com.example.issuemanagement.dto.IssueDto;
import com.example.issuemanagement.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    Page<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto Issue);
}
