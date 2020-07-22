package com.example.issuemanagement.service.impl;

import com.example.issuemanagement.dto.IssueDto;
import com.example.issuemanagement.entity.Issue;
import com.example.issuemanagement.repository.IssueRepository;
import com.example.issuemanagement.service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository; //inject etmek için Autowired setten yapıyor
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper){

        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("Issue Date canno be null");
        }
        Issue issueDb= modelMapper.map(issue, Issue.class);

        issueDb=issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {

        return null;
    }

    @Override
    public Page<IssueDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueDto Issue) {
        return null;
    }
}
