package com.aprende.couto.Controle;

import com.aprende.couto.Model.Aluno;
import com.aprende.couto.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }


    @GetMapping
    public List<Aluno> buscarAlunos() {
        return service.listaDeAluno();
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno novoAluno) {
        return service.criarAluno(novoAluno);
    }


    @PutMapping ("/{id}")
    public Aluno atualizaAluno(@PathVariable Long id,@RequestBody Aluno alteraAluno) {
        Aluno atualizado = service.buscarAlunoId(id);
        if (atualizado == null) return null;

        atualizado.setNome(alteraAluno.getNome());
        atualizado.setEmail(alteraAluno.getEmail());
        atualizado.setTelefone(alteraAluno.getTelefone());

        return service.criarAluno(atualizado);
    }



    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id) {
        service.deletarAluno(id);

    }

    @GetMapping("{/id}")
    public Aluno buscaAlunoPorId(@PathVariable Long id) {
        return service.buscarAlunoId(id);




    }

}
