package br.com.biblioteca.controller;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.DAO.DAO;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Pessoa;

@Controller
@RequestMapping("/")
public class EmprestimoController {

	@Autowired
	private DAO<Emprestimo> emprestimoDAO;
	@Autowired
	private DAO<Pessoa> pessoaDAO;
	@Autowired
	private DAO<Livro> livroDAO;
	
	
	@RequestMapping("/emprestimo")
	public ModelAndView emprestimo() {
		ModelAndView mv = new ModelAndView("emprestimo");

		DetachedCriteria criteriaLivro = DetachedCriteria.forClass(Livro.class);
		DetachedCriteria criteriaPessoa = DetachedCriteria.forClass(Pessoa.class);
		List<Livro> listaLivros = livroDAO.searchModels(criteriaLivro);
		List<Pessoa> listaPessoas = pessoaDAO.searchModels(criteriaPessoa);

		mv.addObject("listaPessoas", listaPessoas);
		mv.addObject("listaLivros", listaLivros);
		return mv;
	}

	@RequestMapping("/cadastraEmprestimo")
	public ModelAndView cadastraEmprestimo(@ModelAttribute("cadastraEmprestimo") Emprestimo emprestimo, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastraEmprestimo");
		return mv;
	}

	@RequestMapping("/editaEmprestimo")
	public ModelAndView editaEmprestimo(@ModelAttribute("editaEmprestimo") Emprestimo emprestimo, BindingResult result) {
		ModelAndView mv = new ModelAndView("editaEmprestimo");
		return mv;
	}

	@RequestMapping(value = "/saveEmprestimo", method = RequestMethod.POST)
	public String saveEmprestimo(@ModelAttribute("cadastraEmprestimo") Emprestimo emprestimo, BindingResult result) {

		emprestimoDAO.save(emprestimo);

		return "Cadastrado com Sucesso!";
	}

	@RequestMapping(value = "/deleteEmprestimo", method = RequestMethod.POST)
	public String deleteEmprestimo(@ModelAttribute("editaEmprestimo") Emprestimo emprestimo, BindingResult result) {

		emprestimoDAO.delete(emprestimo);

		return "Apagado com Sucesso!";
	}

}
