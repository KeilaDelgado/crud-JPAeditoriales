/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.jpa2022.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.ucs.jpa2022.entity.Post;
import pe.edu.ucs.jpa2022.repository.PostRepository;
import pe.edu.ucs.jpa2022.service.PostService;

/**
 *
 * @author admin
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    
    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post read(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }
    
}
