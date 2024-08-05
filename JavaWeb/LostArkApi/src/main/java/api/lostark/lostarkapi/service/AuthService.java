package api.lostark.lostarkapi.service;

import api.lostark.lostarkapi.dto.AuthJoinDTO;

public interface AuthService {
    static class MidExistException extends Exception {}

    void join(AuthJoinDTO dto) throws MidExistException;
}
