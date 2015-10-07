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
import br.com.biblioteca.model.Livro;

@Controller
@RequestMapping("/")
public class LivroController {

	@Autowired
	private DAO<Livro> livroDAO;

	@RequestMapping("/livro")
	public ModelAndView livro() {
		ModelAndView mv = new ModelAndView("livro");

		DetachedCriteria criteria = DetachedCriteria.forClass(Livro.class);
		List<Livro> listaLivros = livroDAO.searchModels(criteria);

		mv.addObject("listaLivros", listaLivros);
		return mv;
	}

	@RequestMapping("/cadastraLivro")
	public ModelAndView cadastraLivro(@ModelAttribute("cadastraLivro") Livro livro, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastraLivro");
		return mv;
	}

	@RequestMapping("/editaLivro")
	public ModelAndView editaLivro(@ModelAttribute("editaLivro") Livro livro, BindingResult result) {
		ModelAndView mv = new ModelAndView("editaLivro");
		return mv;
	}

	@RequestMapping(value = "/saveLivro", method = RequestMethod.POST)
	public String saveLivro(@ModelAttribute("cadastraLivro") Livro livro, BindingResult result) {

		livroDAO.save(livro);

		return "Cadastrado com Sucesso!";
	}

	@RequestMapping(value = "/updateLivro", method = RequestMethod.POST)
	public String updateLivro(@ModelAttribute("editaLivro") Livro livro, BindingResult result) {

		livroDAO.update(livro);

		return "Editado com Sucesso!";
	}

	@RequestMapping(value = "/deleteLivro", method = RequestMethod.POST)
	public String deleteLivro(@ModelAttribute("editaLivro") Livro livro, BindingResult result) {

		livroDAO.delete(livro);

		return "Apagado com Sucesso!";
	}

}
