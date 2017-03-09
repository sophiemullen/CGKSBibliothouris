package be.cegeka.bibliothouris.domain.member;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class MemberRepository {

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        members.add(member);
    }

    public List<Member> getAllMembers(){
        return members;
    }
}
