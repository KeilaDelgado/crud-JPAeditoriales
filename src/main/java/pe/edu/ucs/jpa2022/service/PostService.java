/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.ucs.jpa2022.service;

import java.util.List;
import pe.edu.ucs.jpa2022.entity.Post;

/**
 *
 * @author admin
 */
public interface PostService {
    Post create(Post post);
    Post update(Post post);
    void delete(int id);
    Post read(int id);
    List<Post> readAll();
}
