package com.io.admin.repository;

import com.io.admin.model.Work;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface WorkRepository extends CrudRepository<Work, Integer> {
}
