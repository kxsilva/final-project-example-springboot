package com.treina.recife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.treina.recife.model.DadosPessoais;
import com.treina.recife.service.DadosPessoaisService;

@RestController
public class DadosPessoaisController {
    
    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    @PostMapping("/dadospessoais")
    public DadosPessoais criarDadosPessoais(@RequestBody DadosPessoais dadosPessoais){
        return dadosPessoaisService.save(dadosPessoais);
    }
    
    @GetMapping("/dadospessoais")
    public List<DadosPessoais> lerDadosPessoais(){
        return dadosPessoaisService.findAll();
    }

    @GetMapping("/dadospessoais/{id}")
    public DadosPessoais lerDadosPessoaisPeloId(@PathVariable("id") long id){
        return dadosPessoaisService.findById(id).get();
    }

    @DeleteMapping("/dadospessoais/{id}")
    public String deletarDadosPessoais(@PathVariable("id") long id){
        dadosPessoaisService.deleteById(id);
        return "Rede social deletada com sucesso.";
    }

    @PutMapping("/dadospessoais")
    public DadosPessoais atualizarDadosPessoais(@RequestBody DadosPessoais dadosPessoais){
        DadosPessoais dadosPessoaisBD = dadosPessoaisService.findById(dadosPessoais.getId()).get();
        dadosPessoaisBD.setCpf(dadosPessoais.getCpf());
        dadosPessoaisBD.setRg(dadosPessoais.getRg());
        dadosPessoaisBD.setTituloEleitor(dadosPessoais.getTituloEleitor());
        dadosPessoaisBD.setPis(dadosPessoais.getPis());

        dadosPessoaisBD = dadosPessoaisService.save(dadosPessoaisBD);

        return dadosPessoaisBD;
    }

}
