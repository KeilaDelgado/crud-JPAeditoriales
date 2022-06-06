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
import pe.edu.ucs.jpa2022.entity.Editorial;
import pe.edu.ucs.jpa2022.service.EditorialService;


/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/editorial")
public class EditorialtRestController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/all")
    public List<Editorial> getEditorial() {
        return editorialService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> getEditorial(@PathVariable int id) {
        Editorial post = editorialService.read(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public void deleteEditorial(@PathVariable int id) {        
        editorialService.delete(id);
    }
    @PostMapping("/add")
    public Editorial addEditorial(@RequestBody Editorial editorial) {  
        return editorialService.create(editorial);
    }
    @PutMapping("/edit")
    public Editorial editEditorial(@RequestBody Editorial editorial) {  
        Editorial edi = new Editorial(editorial.getId(),editorial.getNombre(),editorial.getPais(),editorial.getEstado());
        System.out.println(editorial.getId()+" , "+editorial.getNombre()+" , "+editorial.getPais()+" , "+editorial.getEstado());
        return editorialService.update(editorial);
    }
}
