package com.udeA.Ciclo3.controller;

import com.udeA.Ciclo3.modelos.Empresa;
import com.udeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ControlPrueba {

    @Autowired
    EmpresaService empresaService;

    @GetMapping({"/","/VerEmpresas"})
    public String viewEmpresa(Model model, @ModelAttribute("mensaje") String mensaje)
    {
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);

        return "verEmpresas2";//llamamos al HTML
    }
}
