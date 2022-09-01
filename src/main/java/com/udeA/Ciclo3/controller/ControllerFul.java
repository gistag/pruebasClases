package com.udeA.Ciclo3.controller;

import com.udeA.Ciclo3.modelos.Empresa;
import com.udeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ControllerFul {
    @Autowired
    EmpresaService empresaService;

    @GetMapping({"/Empresas}","/VerEmpresa"})
    public String viewEmpresas(Model model){
       List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
       model.addAttribute("emplist",listaEmpresas);
       return "verEmpresas";

    }
    /*@GetMapping("/hola")
    public String hello(){
        return "ciclo 3.. saldremos vivos de este!";
    }*/
}
