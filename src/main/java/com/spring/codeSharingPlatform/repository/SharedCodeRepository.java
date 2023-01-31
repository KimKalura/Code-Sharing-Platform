package com.spring.codeSharingPlatform.repository;

import com.spring.codeSharingPlatform.model.SharedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SharedCodeRepository extends JpaRepository<SharedCode, Long> {

}
