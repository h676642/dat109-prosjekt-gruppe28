package no.hvl.dat109.kontrollere;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.persistence.OneToMany;
import no.hvl.dat109.Emne;
import no.hvl.dat109.Forelesning;
import no.hvl.dat109.Person;
import no.hvl.dat109.Tilbakemelding;
import no.hvl.dat109.repo.EmneRepo;
import no.hvl.dat109.repo.PersonRepo;

public class EmneController {

	@Autowired
	EmneRepo emneRepo;

	@Autowired
	PersonRepo personRepo;

	public EmneController() {
	}

	@GetMapping("/innlogging")
	public String visInnlogging() {
		return "innlogging";
	}

	@PostMapping("/innlogging")
	public String loggInn(Model model, String type, String brukernavn) {
		int bn = Integer.parseInt(brukernavn);
		if (type.toLowerCase().contains("student")) {
			Person s = personRepo.findById(bn).orElse(null);
			if (s != null) {
				model.addAttribute(s);
				return "redirect:oversikt"; // skal vise oversikt over fag, så skal man kunne velge fag
			}
		}
		return "innlogging";
	}

	public boolean giVurdering(String emnekode, String semester, int forelesningsnr, int tilbakemelding,
			int brukernavn) {
		Emne emne = finnEmne(emnekode, semester);
		Person student = personRepo.findById(brukernavn).orElse(null);
		if (emne != null && student != null && student.harEmne(emne) && !student.erLektor()) {
			return emne.giVurdering(forelesningsnr, tilbakemelding, student);
		}
		return false;
	}

	@GetMapping("/oversikt")
	public String visEmner(Model model) {
		String s = (String) model.getAttribute("brukernavn");
		Person student = personRepo.findById(Integer.parseInt(s)).orElse(null);
		if (student != null) {
			model.addAttribute("emner", student.getEmner());
		}

		return "oversikt";
	}

	private Emne finnEmne(String emnekode, String semester) {
		List<Emne> emner = emneRepo.findAll();
		for (Emne e : emner) {
			if (emnekode.equals(e.getEmnekode()) && semester.equals(e.getSemester())) {
				return e;
			}
		}
		return null;
	}

//	@GetMapping("/resultat")
//	public String getResultat(Model model, @RequestParam String emnekode, @RequestParam int forelesningsnr) {
//		model.addAttribute("emnekode", emnekode);
//		model.addAttribute("forelesningsnr", forelesningsnr);
//
//		Emne emne = emneRepo.findByEmnekode(emnekode);
//		
//		for (Forelesning f : emne.ge)
//
//		if (f != null) {
//			model.addAttribute("forelesning", f);
//		}
//
//		model.addAllAttributes(resultat);
//
//		return "ressultat";
//	}

//	public double getResultat(String emnekode, int forelesningsnr) {
//		return finnEmne(emnekode).getResultat(int forelesningsnr);
//
//		double resultat = null;
//		
//		Forelesning fo = forelesningRepository.findByEmnekodeAndForelesningsnr(emnekode, forelesningsnr);
//		
//		for(Forelesning f : forelesninger) {
//			if(f.getEmnekode().equals(emnekode) && f.getForelesningsnr() == forelesningsnr) {
//				fo = f;
//			}
//		}
//		
//		List<Tilbakemelding> tilbakemeldinger = fo.getTilbakemelding();
//		
//		for(Tilbakemelding t : tilbakemeldinger) {
//			resultat += t.getTilbakemelding();
//		}
//		
//		
//		return resultat;
//	}

//	public void giVurdering(int studentId, String emnekode, int forelesningsnr, int tilbakemelding){
//		Forelesning f = forelesninger.stream()
//									 .filter(fo -> fo.getEmnekode().equals(emnekode))
//									 .filter(a -> a.getForelesningsnr() == forelesningsnr)
//									 .findFirst()
//									 .orElse(null);
//		
//		if(f != null) {
//			Tilbakemelding t = new Tilbakemelding(tilbakemelding, studentId);
//			f.registrerTilbakemelding(t);
//		}
//	}

//	public List<Tilbakemelding> getTilbakemeldinger(String emnekode){
//		
//	}

//	@GetMapping("/vurderingskjema")
//	public String vurderingsSkjema(Model model, @RequestParam String emnekode, @RequestParam int forelesningsnr) {
//		model.addAttribute("emnekode", emnekode);
//		model.addAttribute("forelesningsnr", forelesningsnr);
//		return "vurderingskjema";
//	}
//	
//	@PostMapping("/vurderingskjema")
//	public String sendVurderingSkjema(Model model, RedirectAttributes ra){
//		
//		
//		emneRepo.save(forelensing, objekt);
//		
//		
//		return "vurderingskjema";
//	}

}
