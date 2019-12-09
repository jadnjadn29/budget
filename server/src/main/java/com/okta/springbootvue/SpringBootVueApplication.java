package com.okta.springbootvue;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import com.okta.springbootvue.Entity.*;
import com.okta.springbootvue.Repository.*;
@SpringBootApplication  
public class SpringBootVueApplication {
    public static void main(String[] args) {  
      SpringApplication.run(SpringBootVueApplication.class, args);  
    }
    
    @Bean
    ApplicationRunner init(ClubRepository clubRepository, ClubTypeRepository clubtypeRepository,
    MemberRepository memberRepository, BudgetRepository budgetRepository) {
      return args -> {

        Stream.of("คนไข้1", "คนไข้2", "คนไข้3","fkdsig").forEach(club -> {
          Club p = new Club();
          p.setClubName(club);
          clubRepository.save(p);
        });

        Stream.of("นายแพทย์1", "นายแพทย์2", "นายแพทย์3","ippppf").forEach(clubtype -> {
          ClubType d = new ClubType();
          d.setClubTypeName(clubtype);
          clubtypeRepository.save(d);
        });

        Stream.of("ยาลดไข้", "ยาแก้ปวด", "ยาฆ่าเชื้อ").forEach(member -> {
          Member med = new Member();
          med.setMemberName(member);
          memberRepository.save(med);
        });
        
        clubRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Patient บน Terminal
        memberRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Patient บน Terminal
        clubtypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Patient บน Terminal
      };
    }

}