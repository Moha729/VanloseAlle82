package com.example.vanlosealle82.Service;

import com.example.vanlosealle82.Model.Member;
import com.example.vanlosealle82.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepo repo;

    public void addNew(Member member){
        repo.addNew(member);
    }
}
