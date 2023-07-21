package com.ktoda.cruddemo.repository.techpersonal;

import com.ktoda.cruddemo.entity.techpersonal.TechPersonal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechPersonalRepository extends CrudRepository<TechPersonal, Integer> {

}
