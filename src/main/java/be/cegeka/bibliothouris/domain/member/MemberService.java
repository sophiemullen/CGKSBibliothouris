package be.cegeka.bibliothouris.domain.member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberService {

    @Inject
    private MemberRepository memberRepository;

    public void addMember(String INSS, String firstName, String lastName, String street, int number, int postalCode, String city){
        Member member = new Member(INSS, firstName, lastName, street, number, postalCode, city);
        memberRepository.addMember(member);
    }

    public List<Member> getAllMembers(){
        return memberRepository.getAllMembers();
    }
}
