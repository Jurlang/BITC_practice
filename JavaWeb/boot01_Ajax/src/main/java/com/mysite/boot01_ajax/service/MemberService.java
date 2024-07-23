package com.mysite.boot01_ajax.service;

import com.mysite.boot01_ajax.dto.MemberJoinDTO;

public interface MemberService {

    static class MidExistException extends Exception {}

    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
}
