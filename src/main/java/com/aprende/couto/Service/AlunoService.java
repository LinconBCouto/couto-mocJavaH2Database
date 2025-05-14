package com.aprende.couto.Service;

import com.aprende.couto.Interface.AlunoRepository;
import com.aprende.couto.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;

    }

    public List<Aluno> listaDeAluno(){
        return repository.findAll();
    }

    public Aluno criarAluno(Aluno alunos){
        return repository.save(alunos);
    }


    public void deletarAluno(Long id){
        repository.deleteById(id);
    }

    public Aluno buscarAlunoId(Long id){
        return repository.findById(id).orElse(null);
    }





}
