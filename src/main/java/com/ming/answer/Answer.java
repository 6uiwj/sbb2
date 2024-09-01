package com.ming.answer;

import com.ming.question.Question;
import com.ming.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    public Question question;

    @Column(columnDefinition = "TEXT")
    public String content;

    public LocalDateTime createDate;

    @ManyToOne
    public SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    public Set<SiteUser> voter;
}
