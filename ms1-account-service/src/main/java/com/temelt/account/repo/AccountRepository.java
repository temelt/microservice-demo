package com.temelt.account.repo;

import com.temelt.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by temelt on 28.01.2019.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
