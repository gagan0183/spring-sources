package com.spring.student;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/AdmissionForm", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception {
		String pointer = "EXCEP";
		if(pointer.equalsIgnoreCase("EXCEP")) {
			throw new ArithmeticException();
		}
		ModelAndView view = new ModelAndView("AdmissionForm");
		return view;
	}
	
	@ModelAttribute
	public void addCommonModel(Model model) {
		model.addAttribute("headerMessage", "This is the header message");
	}
	
	@RequestMapping(value="/Admissionsuccess", method=RequestMethod.POST)
	public ModelAndView successAdmission(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView view = new ModelAndView("AdmissionForm");
			return view;
		}
		ModelAndView view = new ModelAndView("AdmissionSuccess");
		return view;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[]{"studentMobile"});
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd**mm**yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(simpleDateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
}
