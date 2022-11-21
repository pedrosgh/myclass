package com.nttdata.myclass.controller;

import com.nttdata.myclass.model.*;
import com.nttdata.myclass.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IDisciplinaService disciplinaService;

    @Autowired
    private IProfessorService professorService;

    @Autowired
    private IAlunoService alunoService;

    @Autowired
    private IAulaService aulaService;

    @RequestMapping("/")
    public String viewLoginPage(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateAccount(@ModelAttribute("account") Account account, Model model) {
        Account loggedAccount = accountService.validateLogin(account);

        if(loggedAccount != null) {
            return "redirect:/index";
        } else {
            model.addAttribute("message", "O username ou password inseridos estão errados.");
            return "error";
        }
    }

    @RequestMapping("/index")
    public String viewHomePage(Model model) {
        List<Disciplina> listDisciplinas = disciplinaService.findAll();
        List<Professor> listProfessores = professorService.findAll();
        List<Aluno> listAlunos = alunoService.findAll();
        List<Aula> listAulas = aulaService.findAll();
        model.addAttribute("listDisciplinas", listDisciplinas);
        model.addAttribute("listProfessores", listProfessores);
        model.addAttribute("listAlunos", listAlunos);
        model.addAttribute("listAulas", listAulas);

        return "index";
    }

    // DISCIPLINAS
    @RequestMapping("/new/disciplina")
    public String showNewDisciplinaPage(Model model) {
        Disciplina disciplina = new Disciplina();
        model.addAttribute("disciplina", disciplina);

        return "new_disciplina";
    }

    @RequestMapping(value = "/save/disciplina", method = RequestMethod.POST)
    public String saveDisciplina(@ModelAttribute("disciplina") Disciplina disciplina, Model model) {
        disciplina = disciplinaService.create(disciplina);

        if(disciplina != null) {
            return "redirect:/index";
        } else {
            model.addAttribute("message", "A area especificada não é valida.");
            return "error";
        }
    }

    @RequestMapping("/edit/disciplina/{id}")
    public ModelAndView showEditDisciplinaPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_disciplina");
        Optional<Disciplina> disciplina = disciplinaService.findById(id);
        mav.addObject("disciplina", disciplina);

        return mav;
    }

    @RequestMapping("/delete/disciplina/{id}")
    public String deleteDisciplina(@PathVariable(name = "id") int id) {
        disciplinaService.delete(id);
        return "redirect:/index";
    }

    // PROFESSORES
    @RequestMapping("/new/professor")
    public String showNewProfessorPage(Model model) {
        Professor professor = new Professor();
        model.addAttribute("professor", professor);
        List<Disciplina> listDisciplinas = disciplinaService.findAll();
        model.addAttribute("listDisciplinas", listDisciplinas);

        return "new_professor";
    }

    @RequestMapping(value = "/save/professor", method = RequestMethod.POST)
    public String saveProfessor(@ModelAttribute("professor") Professor professor) {
        professorService.create(professor);

        return "redirect:/index";
    }

    @RequestMapping("/edit/professor/{cpf}")
    public ModelAndView showEditProfessorPage(@PathVariable(name = "cpf") String cpf) {
        ModelAndView mav = new ModelAndView("edit_professor");
        Optional<Professor> professor = professorService.findById(cpf);
        mav.addObject("professor", professor);
        mav.addObject("disciplinaDoProfessor", professor.get().getDisciplina());
        List<Disciplina> listDisciplinas = disciplinaService.findAll();
        mav.addObject("listDisciplinas", listDisciplinas);

        return mav;
    }

    @RequestMapping("/delete/professor/{cpf}")
    public String deleteProfessor(@PathVariable(name = "cpf") String cpf) {
        professorService.delete(cpf);
        return "redirect:/index";
    }

    // ALUNOS
    @RequestMapping("/new/aluno")
    public String showNewAlunoPage(Model model) {
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);

        return "new_aluno";
    }

    @RequestMapping(value = "/save/aluno", method = RequestMethod.POST)
    public String saveAluno(@ModelAttribute("aluno") Aluno aluno) {
        alunoService.create(aluno);

        return "redirect:/index";
    }

    @RequestMapping("/edit/aluno/{matricula}")
    public ModelAndView showEditAlunoPage(@PathVariable(name = "matricula") String matricula) {
        ModelAndView mav = new ModelAndView("edit_aluno");
        Optional<Aluno> aluno = alunoService.findById(matricula);
        mav.addObject("aluno", aluno);

        return mav;
    }

    @RequestMapping("/delete/aluno/{matricula}")
    public String deleteAluno(@PathVariable(name = "matricula") String matricula) {
        alunoService.delete(matricula);
        return "redirect:/index";
    }

    // AULAS
    @RequestMapping("/new/aula")
    public String showNewAulaPage(Model model) {
        Aula aula = new Aula();
        model.addAttribute("aula", aula);
        List<Professor> listProfessores = professorService.findAll();
        model.addAttribute("listProfessores", listProfessores);
        List<Aluno> listAlunos = alunoService.findAll();
        model.addAttribute("listAlunos", listAlunos);

        return "new_aula";
    }

    @RequestMapping(value = "/save/aula", method = RequestMethod.POST)
    public String saveAula(@ModelAttribute("aula") Aula aula) {
        aulaService.create(aula);

        return "redirect:/index";
    }

    @RequestMapping("/edit/aula/{id}")
    public ModelAndView showEditAulaPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_aula");
        Optional<Aula> aula = aulaService.findById(id);
        mav.addObject("aula", aula);
        mav.addObject("professorDaAula", aula.get().getProfessor());
        mav.addObject("alunoDaAula", aula.get().getAluno());
        List<Professor> listProfessores = professorService.findAll();
        mav.addObject("listProfessores", listProfessores);
        List<Aluno> listAlunos = alunoService.findAll();
        mav.addObject("listAlunos", listAlunos);

        return mav;
    }

    @RequestMapping("/delete/aula/{id}")
    public String deleteAula(@PathVariable(name = "id") int id) {
        aulaService.delete(id);
        return "redirect:/index";
    }
}
