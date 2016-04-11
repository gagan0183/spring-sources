package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	
	@Autowired(required=false)
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("texteditor constructor");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
