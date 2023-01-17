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

import com.treina.recife.model.RedesSociais;
import com.treina.recife.service.RedesSociaisService;

@RestController
public class RedesSociaisController {
    
    @Autowired
    private RedesSociaisService redesSociaisService;

    @PostMapping("/redessociais")
    public RedesSociais criarNovaRedeSocial(@RequestBody RedesSociais redesSociais){
        return redesSociaisService.save(redesSociais);
    }

    @GetMapping("/redessociais")
    public List<RedesSociais> lerRedesSociais(){
        return redesSociaisService.findAll();
    } 

    @GetMapping("/redessociais/{id}")
    public RedesSociais lerRedeSocialPeloId(@PathVariable("id") long id){
        return redesSociaisService.findById(id).get();
    }

    @DeleteMapping("/redessociais/{id}")
    public String deletarRedeSocialPeloId(@PathVariable("id") long id){
        redesSociaisService.deleteById(id);
        return "Rede social deletada com sucesso";
    }

    @PutMapping("/redessociais")
    public RedesSociais atualizarRedeSocial(@RequestBody RedesSociais redesSociais){
        RedesSociais redesocialBD = redesSociaisService.findById(redesSociais.getId()).get();
        redesocialBD.setNome(redesSociais.getNome());
        redesocialBD.setLink(redesSociais.getLink());
        redesocialBD = redesSociaisService.save(redesocialBD);

        return redesocialBD;
    }
}
