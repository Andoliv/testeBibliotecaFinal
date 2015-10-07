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
import br.com.biblioteca.model.Pessoa;

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private DAO<Pessoa> pessoaDAO;

	@RequestMapping("/pessoa")
	public ModelAndView pessoa() {
		ModelAndView mv = new ModelAndView("pessoa");

		DetachedCriteria criteria = DetachedCriteria.forClass(Pessoa.class);
		List<Pessoa> listaPessoas = pessoaDAO.searchModels(criteria);

		mv.addObject("listaPessoas", listaPessoas);
		return mv;
	}

	@RequestMapping("/cadastraPessoa")
	public ModelAndView cadastraPessoa(@ModelAttribute("cadastraPessoa") Pessoa pessoa, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastraPessoa");
		return mv;
	}

	@RequestMapping("/editaPessoa")
	public ModelAndView editaPessoa(@ModelAttribute("editaPessoa") Pessoa pessoa, BindingResult result) {
		ModelAndView mv = new ModelAndView("editaPessoa");
		return mv;
	}

	@RequestMapping(value = "/savePessoa", method = RequestMethod.POST)
	public String savePessoa(@ModelAttribute("cadastraPessoa") Pessoa pessoa, BindingResult result) {

		pessoaDAO.save(pessoa);

		return "Cadastrado com Sucesso!";
	}

	@RequestMapping(value = "/updatePessoa", method = RequestMethod.POST)
	public String updatePessoa(@ModelAttribute("editaPessoa") Pessoa pessoa, BindingResult result) {

		pessoaDAO.update(pessoa);

		return "Editado com Sucesso!";
	}

	@RequestMapping(value = "/deletePessoa", method = RequestMethod.POST)
	public String deletePessoa(@ModelAttribute("editaPessoa") Pessoa pessoa, BindingResult result) {

		pessoaDAO.delete(pessoa);

		return "Apagado com Sucesso!";
	}

}
