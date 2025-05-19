package com.management.managementVL101.Controller;
import com.management.managementVL101.Model.Curso;
import com.management.managementVL101.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        return new ResponseEntity<>(cursoService.getAllCursos(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return new ResponseEntity<>(cursoService.getCursoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/modificar")
    public ResponseEntity<Curso> modificarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Curso actualizado = cursoService.modificarCurso(id, curso);
        return ResponseEntity.ok(actualizado);
    }
    

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.createCurso(curso), HttpStatus.CREATED);
    }

    

    
}