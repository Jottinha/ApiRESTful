package com.restful.demo.repository;

import com.restful.demo.model.PhonesVersions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryPhonesVersion extends CrudRepository<PhonesVersions, String> {
    List<PhonesVersions> findAll();
    Optional<PhonesVersions> findById(long idPhone);
}
