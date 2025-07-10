package com.devsuperior.DSPosts.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.DSPosts.model.dto.PostDTO;
import com.devsuperior.DSPosts.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		PostDTO result = postService.findById(id);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(defaultValue = "") String text) {
		List<PostDTO> result = postService.findByTitle(text);
		return ResponseEntity.ok().body(result);
	}
}
