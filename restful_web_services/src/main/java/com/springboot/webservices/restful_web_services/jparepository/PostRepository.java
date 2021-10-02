package com.springboot.webservices.restful_web_services.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.webservices.restful_web_services.jpaentitty.PostEntitty;

@Repository
public interface PostRepository extends JpaRepository<PostEntitty, Integer> {

}
