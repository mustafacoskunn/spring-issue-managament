package com.example.issuemanagement.repository;

import com.example.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> { //bir çok sorogu yapabiliyoruz//sayfalama yapabilirruz


}
