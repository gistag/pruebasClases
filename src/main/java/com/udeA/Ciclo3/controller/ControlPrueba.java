package com.udeA.Ciclo3.controller;

import com.udeA.Ciclo3.modelos.Empresa;
import com.udeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping({"/AgregarEmpresa"})
    public String nuevaEmpresa(Model model, @ModelAttribute("mensaje") String mensaje){
            Empresa emp = new Empresa();
            model.addAttribute("emp", emp);
            model.addAttribute("mensaje", mensaje);
            return "agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpresas";
        }

        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empresa emp=empresaService.getEmpresaById(id);
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "editarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","ActualizarOK");
            return "redirect:/VerEmpresas";
        }

        redirectAttributes.addFlashAttribute("mensaje","ActualizarError");
        return "redirect:/EditarEmpresa";
    }

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(empresaService.deleteEmpresa(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpresas";
        }
        else {
            redirectAttributes.addFlashAttribute("mensaje", "deleteError");
            return "redirect:/VerEmpresas";

        }
    }


    @GetMapping("/EliminarEmpresa2/{id}")
    public String eliminarEmpresa2 (@PathVariable Integer id, RedirectAttributes redirectAttributes){
       try{
           empresaService.deleteEmpresa(id);
       }catch(Exception e){
           redirectAttributes.addFlashAttribute("mensaje","EliminarError");
           return "redirect:/VerEmpresas";
       }
        redirectAttributes.addFlashAttribute("mensaje","EliminarOK");
       return "redirect:/VerEmpresas";


    }



}
