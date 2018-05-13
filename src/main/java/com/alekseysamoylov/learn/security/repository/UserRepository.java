package com.alekseysamoylov.learn.security.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.alekseysamoylov.learn.security.entity.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByName(@Param("name") String name);

    @Override
    <S extends User> S save(S user);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> Iterable<S> saveAll(Iterable<S> users);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteById(Long var1);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void delete(User var1);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll(Iterable<? extends User> var1);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll();
}
