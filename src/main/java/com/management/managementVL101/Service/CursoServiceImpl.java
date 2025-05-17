package com.management.managementVL101.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.managementVL101.Model.Curso;
import com.management.managementVL101.Repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
    }

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso updateCurso(Long id, Curso curso) {
        return null;
    }

    @Override
    public Curso modificarCurso(Long id, Curso cursoModificado) {
        Curso cursoExistente = getCursoById(id);
        cursoExistente.setCursoNombre(cursoModificado.getCursoNombre());
        cursoExistente.setDescripcion(cursoModificado.getDescripcion());
        cursoExistente.setCategoria(cursoModificado.getCategoria());
        cursoExistente.setPrecio(cursoModificado.getPrecio());
        cursoExistente.setEstudianteCapacidad(cursoModificado.getEstudianteCapacidad());
        return cursoRepository.save(cursoExistente);
    }
    
}
