package com.covid19.app.member.model.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.covid19.app.member.model.vo.Member;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate session;
	
	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		System.out.println(member);
		return session.insert("MEMBER.insertMember", member);
		
	}

	/**
	 * 아이디 중복 확인
	 * @param member_id 아이디 확인
	 * @return
	 */
	public int selectIdcheck(String member_id) {
		// TODO Auto-generated method stub
		return session.selectOne("MEMBER.selectIdcheck",member_id);
	}

	/**
	 * 로그인
	 * @param member 전체 id pw 확인
	 * @return
	 */
	public Member login(Map<String, Object> commandMap) {
		System.out.println(commandMap);
		return session.selectOne("MEMBER.login", commandMap);
	}	

	
	/**
	 * 로그아웃
	 */
	public void logout(HttpSession session) {
		
	}

	/**
	 * 아이디찾기
	 * @param member
	 * @return
	 */
	public String searchId(Member member) {
		return session.selectOne("MEMBER.searchId", member);
	}

	/**
	 * 비밀번호 찾기
	 * @param member
	 * @return count 해서 맞는 정보 확인
	 */
	public int searchPw(Member member) {
		return session.selectOne("MEMBER.searchPw", member);
	}

	/**
	 * 비밀번호 바꾸기 
	 * @param commandMap
	 * @return 완벽하면 return 1해서 돌리기 mav
	 */
	public int changePw(Member member) {
		return session.update("MEMBER.changePw", member);
	}


	
	
}











