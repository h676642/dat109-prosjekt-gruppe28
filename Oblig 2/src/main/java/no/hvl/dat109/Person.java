package no.hvl.dat109;

import java.util.List;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

public class Person {

	private int brukernavn;
	private boolean erLektor;

	@ManyToMany() // må fikses
	private List<Emne> emner;

	public Person(int brukernavn, boolean erLektor, List<Emne> emner) {
		this.brukernavn = brukernavn;
		this.erLektor = erLektor;
		this.emner = emner;
	}

	public int getBrukernavn() {
		return brukernavn;
	}

	public boolean erLektor() {
		return erLektor;
	}

	public List<Emne> getEmner() {
		return emner;
	}

	public void setEmner(List<Emne> emner) {
		this.emner = emner;
	}

	public boolean harEmne(Emne emne) {
		return emner.contains(emne);
	}

}
