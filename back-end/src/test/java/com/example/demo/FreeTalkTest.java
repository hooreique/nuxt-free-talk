package com.example.demo;

import com.example.demo.forum.freetalk.entity.FreeTalkComment;
import com.example.demo.forum.freetalk.entity.FreeTalkPost;
import com.example.demo.forum.freetalk.repository.FreeTalkCommentRepository;
import com.example.demo.forum.freetalk.repository.FreeTalkPostRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles({"dev", "debug"})
public class FreeTalkTest {

    private final Logger log = LoggerFactory.getLogger(FreeTalkTest.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FreeTalkPostRepository freeTalkPostRepository;

    @Autowired
    private FreeTalkCommentRepository freeTalkCommentRepository;

    @Test
    void test() {
        final Member member = memberRepository.save(Member.builder().name("이름").build());
        assertNotNull(member);
        log.debug("Saved member id: {}", member.getId());

        final FreeTalkPost post = freeTalkPostRepository.save(FreeTalkPost.builder()
                .author(member)
                .title("제목")
                .content("내용")
                .build());
        assertNotNull(post);
        log.debug("Saved post id: {}", post.getId());

        final FreeTalkComment commentP = freeTalkCommentRepository.save(FreeTalkComment.builder()
                .author(member)
                .post(post)
                .content("내용")
                .build());
        assertNotNull(commentP);
        log.debug("Saved parent comment id: {}", commentP.getId());

        final FreeTalkComment commentC = freeTalkCommentRepository.save(FreeTalkComment.builder()
                .author(member)
                .post(post)
                .parent(commentP)
                .content("내용")
                .build());
        assertNotNull(commentC);
        log.debug("Saved child comment id: {}", commentC.getId());
    }
}
