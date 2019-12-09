package com.okta.springbootvue.Controller;
import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "http://localhost:8080") //ทำให้ spingboot , vue ส่งข้อมูหากันได้
class BudgetController{
  
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ClubTypeRepository clubtypeRepository;

    @Autowired
    private MemberRepository memberRepository;

  

    public  BudgetController(BudgetRepository budgetRepository,  ClubRepository clubRepository,
    ClubTypeRepository clubtypeRepository, MemberRepository memberRepository
    ){ 
        this.budgetRepository = budgetRepository;
        this.clubRepository = clubRepository;
        this.clubtypeRepository = clubtypeRepository;
        this.memberRepository = memberRepository;
       
    }
    //Get all data in table 
    @GetMapping("/clubs")
    public Collection<Club> getClub(){
        return clubRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/clubtypes")
    public Collection<ClubType> getClubType(){
        return clubtypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/members")
    public Collection<Member> getMember(){
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }

    

    //add data 
    @GetMapping("/club/{name}")
    public Club addclub(@PathVariable String name){
        Club n = new Club();
        n.setClubName(name);
        clubRepository.save(n);
        return n;
    }

    @GetMapping("/clubtype/{name}")
    public ClubType addClubType(@PathVariable String name){
        ClubType n = new ClubType();
        n.setClubTypeName(name);
        clubtypeRepository.save(n);
        return n;
    }

    @GetMapping("/member/{name}")
    public Member addMember(@PathVariable String name){
        Member n = new Member();
        n.setMemberName(name);
        memberRepository.save(n);
        return n;
    }

    @GetMapping("/budget/{amount}/{clubId}/clubtypeId}/{memberId}")
    public Budget addBudget(
    
    @PathVariable Long clubId, 
    @PathVariable Long clubtypeId, 
    @PathVariable Long memberId,
    @PathVariable int amount){

        Budget budget = new Budget();
        budget.setAmount(amount);
        
        Club club = clubRepository.findClubById(clubId);
        ClubType clubtype = clubtypeRepository.findClubTypeById(clubtypeId);
        Member member = memberRepository.findMemberById(memberId);

        budget.setClub(club);
        budget.setClubType(clubtype);
        budget.setMember(member);

     

    
       

        return budgetRepository.save(budget);
      

        

    
    }
}
    