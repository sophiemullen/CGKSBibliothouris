package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.member.Member;
import be.cegeka.bibliothouris.domain.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Inject
    private MemberService memberService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addMember(@RequestParam(value = "INSS", required = true) String INSS,
                          @RequestParam(value = "firstName") String firstName,
                          @RequestParam(value = "lastName", required = true) String lastName,
                          @RequestParam(value = "street") String street,
                          @RequestParam(value = "number") int number,
                          @RequestParam(value = "postalCode") int postalCode,
                          @RequestParam(value = "city", required = true) String city){
        memberService.addMember(INSS, firstName, lastName, street, number, postalCode, city);

    }

}
/*
unique number (INSS), last name, first name, street, number, postal code, city

 */
