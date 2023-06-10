package com.example.demo.forum.freetalk.web;

import com.example.demo.forum.freetalk.repository.FreeTalkCommentRepository;
import com.example.demo.forum.freetalk.repository.FreeTalkPostRepository;
import com.example.demo.member.repository.MemberRepository;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/forum/free-talk")
@RequiredArgsConstructor
public class FreeTalkController {

    private final MemberRepository memberRepository;

    private final FreeTalkPostRepository postRepository;

    private final FreeTalkCommentRepository commentRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public Page<Map<String, Object>> page(
            final @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(post -> new ImmutableMap.Builder<String, Object>()
                        .put("id", post.getId())
                        .put("authorId", post.getAuthor().getId())
                        .put("authorName", post.getAuthor().getName())
                        .put("title", post.getTitle())
                        .build());
    }
}
