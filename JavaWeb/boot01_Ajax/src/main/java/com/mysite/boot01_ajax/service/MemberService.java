package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.dto.MemberJoinDTO;
import com.mysite.boot01_ajax.security.dto.MemberSecurityDTO;

public interface MemberService {

    static class MidExistException extends Exception {}

    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
    void modify(MemberJoinDTO memberJoinDTO) throws MidExistException;
}
