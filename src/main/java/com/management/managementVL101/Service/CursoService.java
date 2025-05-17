package com.management.managementVL101.Service;
import java.util.List;
import com.management.managementVL101.Model.Curso;

public interface CursoService {

    List<Curso> getAllCursos();
    Curso getCursoById(Long id);
    Curso createCurso(Curso curso);
    Curso updateCurso(Long id, Curso curso);

    Curso modificarCurso(Long id, Curso cursoModificado);
}

