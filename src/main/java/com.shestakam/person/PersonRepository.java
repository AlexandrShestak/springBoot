package com.shestakam.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<Person> findAll(Pageable pageable);

    @Override
    @PostAuthorize("returnObject.firstName == principal.username or hasRole('ROLE_ADMIN')")
    Person findOne(Long aLong);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Person> findByFirstNameLike(@Param("firstName") String firstName);

    Person findByFirstNameEquals(String username);
}