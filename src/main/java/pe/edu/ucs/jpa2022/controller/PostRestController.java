/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.jpa2022.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.ucs.jpa2022.entity.Post;
import pe.edu.ucs.jpa2022.service.PostService;


/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getPosts() {
        return postService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post post = postService.read(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.delete(id);
    }
    @PostMapping("/add")
    public Post addPost(@RequestBody Post post) {  
        return postService.create(post);
    }
    @PutMapping("/edit")
    public Post editPost(@RequestBody Post post) {  
        Post pos = new Post(post.getId(),post.getTitulo(),post.getDescripcion());
        System.out.println(post.getId()+" , "+post.getTitulo()+" , "+post.getDescripcion());
        return postService.update(post);
    }
}
