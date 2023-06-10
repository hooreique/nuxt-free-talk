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
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FreeTalkComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private FreeTalkPost post;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private FreeTalkComment parent;

    @NotEmpty
    @Size(max = 255)
    @Column(nullable = false)
    private String content;

    @Builder
    private FreeTalkComment(
            final @NotNull Member author,
            final @NotNull FreeTalkPost post,
            final @Nullable FreeTalkComment parent,
            final @NotEmpty @Size(max = 255) String content) {
        this.author = author;
        this.post = post;
        this.parent = parent;
        this.content = content;
    }
}
