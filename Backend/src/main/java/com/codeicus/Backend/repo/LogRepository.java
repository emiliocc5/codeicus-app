package com.codeicus.Backend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeicus.Backend.model.Log;

@Repository
public interface LogRepository extends CrudRepository <Log, Integer> {

}
