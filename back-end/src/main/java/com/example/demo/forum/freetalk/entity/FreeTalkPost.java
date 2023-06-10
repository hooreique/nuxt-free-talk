package com.example.demo.forum.freetalk.entity;

import com.example.demo.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FreeTalkPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member author;

    @NotEmpty
    @Size(max = 255)
    @Column(nullable = false)
    private String title;

    @NotEmpty
    @Size(max = 255)
    @Column(nullable = false)
    private String content;

    @Builder
    private FreeTalkPost(
            final @NotNull Member author,
            final @NotEmpty @Size(max = 255) String title,
            final @NotEmpty @Size(max = 255) String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
