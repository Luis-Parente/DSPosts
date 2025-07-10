package com.devsuperior.DSPosts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DSPosts.model.dto.PostDTO;
import com.devsuperior.DSPosts.model.entities.Post;
import com.devsuperior.DSPosts.repositories.PostRepository;
import com.devsuperior.DSPosts.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Transactional(readOnly = true)
	public PostDTO findById(String id) {
		Post entity = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found"));
		return new PostDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<PostDTO> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text).stream().map(x -> new PostDTO(x)).toList();
	}
}
