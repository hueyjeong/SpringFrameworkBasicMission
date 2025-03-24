package net.jayzen.springframeworkbasic.controller;

import net.jayzen.springframeworkbasic.domain.Member;
import net.jayzen.springframeworkbasic.domain.dto.MemberFindResponse;
import net.jayzen.springframeworkbasic.domain.dto.MemberRegisterRequest;
import net.jayzen.springframeworkbasic.domain.dto.MemberRegisterResponse;
import net.jayzen.springframeworkbasic.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping()
    public MemberRegisterResponse saveMember(@RequestBody MemberRegisterRequest memberRegisterRequest) throws Exception {
        return memberService.save(memberRegisterRequest);
    }

    @GetMapping()
    public List<MemberFindResponse> findAll() {
        return memberService.findAll();
    }
}
