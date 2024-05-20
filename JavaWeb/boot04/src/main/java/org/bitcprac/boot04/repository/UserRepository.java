package org.bitcprac.boot04.repository;

import org.bitcprac.boot04.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
