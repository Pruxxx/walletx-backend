package com.pruxx.walletx.repo;
import com.pruxx.walletx.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AppUserRepo extends JpaRepository<AppUser, Long> {
        boolean existsByEmail(String email);
}
