package com.example.vanlosealle82.Repository;

import com.example.vanlosealle82.Model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepo {

    @Autowired
    JdbcTemplate template;

    public List<Member> fetchAll(){
        String sql = "SELECT * FROM members";
        RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(Member.class);
        return template.query(sql, memberRowMapper);
    }

    public void addNew(Member newMember){
        String sql = "INSERT INTO members (name) VALUES (?)";
        template.update(sql, newMember.getName());
    }

    public Member findById(int id){
        String sql = "SELECT * FROM members WHERE id = ?";
        RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(Member.class);
        return template.queryForObject(sql, memberRowMapper, id);
    }
}
