package com.devsuperior.DSPosts.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.DSPosts.model.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
