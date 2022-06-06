/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.jpa2022.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.ucs.jpa2022.entity.Editorial;
import pe.edu.ucs.jpa2022.repository.EditorialRepository;
import pe.edu.ucs.jpa2022.service.EditorialService;

/**
 *
 * @author admin
 */
@Service
public class EditorialServiceImpl implements EditorialService{
    @Autowired
    private EditorialRepository editorialRepository;
    
    @Override
    public Editorial create(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public Editorial update(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public void delete(int id) {
        editorialRepository.deleteById(id);
    }

    @Override
    public Editorial read(int id) {
        return editorialRepository.findById(id).get();
    }

    @Override
    public List<Editorial> readAll() {
        return editorialRepository.findAll();
    }
    
}
