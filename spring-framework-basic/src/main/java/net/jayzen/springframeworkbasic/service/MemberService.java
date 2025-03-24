package net.jayzen.springframeworkbasic.service;

import net.jayzen.springframeworkbasic.domain.Member;
import net.jayzen.springframeworkbasic.domain.dto.MemberFindResponse;
import net.jayzen.springframeworkbasic.domain.dto.MemberRegisterRequest;
import net.jayzen.springframeworkbasic.domain.dto.MemberRegisterResponse;
import net.jayzen.springframeworkbasic.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(@Qualifier("MemberRepositoryMemVer") MemberRepository memberRepository, ModelMapper modelMapper) { //@Qualifier("MemberRepositoryMemVer")
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    public MemberRegisterResponse save(MemberRegisterRequest memberRegisterRequest) throws Exception {
        Member member = modelMapper.map(memberRegisterRequest, Member.class);
        member = memberRepository.save(member);
        return modelMapper.map(member, MemberRegisterResponse.class);
    }

    public List<MemberFindResponse> findAll() {
        return modelMapper.map(memberRepository.findAll(), new TypeToken<List<MemberFindResponse>>(){}.getType());
    }
}
