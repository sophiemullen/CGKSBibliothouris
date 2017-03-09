package be.cegeka.bibliothouris.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MemberServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    private Member member, member2, member3;

    @Before
    public void setUp(){
        member = new Member("1234", "Sophie", "Mullen", "Lazarijstraat", 180, 3500, "Hasselt");
        member2 = new Member("1346", "Brad", "Pitt", "HollywoodStreet", 23, 5000, "Brussels");
        member3 = new Member("5679", "Jennifer", "Smith", "Kapelstraat", 54, 3500, "Hasselt");
    }

    @Test
    public void addMember_addsSameMemberAsRepo() throws Exception{
        memberService.addMember("1234", "Sophie", "Mullen", "Lazarijstraat", 180, 3500, "Hasselt");
        verify(memberRepository).addMember(member);
    }

    @Test
    public void getAllMembers_ReturnsMembersFromRepo(){
        when(memberRepository.getAllMembers()).thenReturn(Arrays.asList(member, member2, member3));
        Assertions.assertThat(memberService.getAllMembers()).contains(member, member2, member3);
    }

    //@Test

}