package com.ktoda.cruddemo.repository.techpersonal;

import com.ktoda.cruddemo.entity.techpersonal.TechPersonal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechPersonalRepository extends CrudRepository<TechPersonal, Integer> {
    @Query("select t from TechPersonal t where t.username = :username")
    Optional<TechPersonal> findByUsername(@Param("username") String username);
}
