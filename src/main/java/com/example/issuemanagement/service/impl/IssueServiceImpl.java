package com.example.issuemanagement.service.impl;

import com.example.issuemanagement.dto.IssueDto;
import com.example.issuemanagement.entity.Issue;
import com.example.issuemanagement.repository.IssueRepository;
import com.example.issuemanagement.service.IssueService;
import com.example.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
            throw new IllegalArgumentException("Issue Date cannot be null");
        }
        Issue issueDb= modelMapper.map(issue, Issue.class);

        issueDb=issueRepository.save(issueDb);
        issue.setId(issueDb.getId());
        return issue;

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue=issueRepository.getOne(id);

        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
      Page<Issue> data= issueRepository.findAll(pageable);
      TPage page=new TPage<IssueDto>();
      IssueDto[] dtos=modelMapper.map(data.getContent(),IssueDto[].class);
      page.setStat(data, Arrays.asList(dtos));
      return page;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {
        return null;
    }
}
