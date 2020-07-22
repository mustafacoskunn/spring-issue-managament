package com.example.issuemanagement.entity;


import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data //getter setterlar
@NoArgsConstructor //boş bir constructor oluşturur
@AllArgsConstructor // dolu constructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") //bir tablodan bir tabloya join işlemi
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //bir çok issue bir tane usere bağlanabilir //fetchte select edildğinde gelir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
