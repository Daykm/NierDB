package com.daykm.web;

import com.daykm.data.WeaponRepository;
import com.daykm.domain.Weapon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("*")
@Controller
public class NierController {

    @Autowired
    WeaponRepository repo;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "nier/index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("weapon", new Weapon());
		return "nier/add";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String submit(Weapon weapon) {
		repo.saveWeapon(weapon);
		return "redirect:list";
	}

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("weapons", repo.getWeapons());
        return "nier/list";
    }
}
