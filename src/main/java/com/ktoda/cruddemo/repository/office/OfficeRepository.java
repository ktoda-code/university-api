package com.ktoda.cruddemo.repository.office;

import com.ktoda.cruddemo.entity.office.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer> {
}
