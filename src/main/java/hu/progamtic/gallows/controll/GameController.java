package hu.progamtic.gallows.controll;

import hu.progamtic.gallows.service.GallowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    private final GallowsService gallowsService;

    @Autowired
    public GameController(GallowsService gallowsService) {
        this.gallowsService = gallowsService;
    }

    @GetMapping("/play")
    public String playGame(Model model) {
        model.addAttribute("gameWord", gallowsService.getWordsToArray());
        model.addAttribute("usedWords", gallowsService.getUsedCharacters());
        model.addAttribute("counter", gallowsService.getCounter());
        return "play";
    }

    @PostMapping("/guess")
    public String guess(@ModelAttribute ("character") char character) {
        gallowsService.charFinder(character);
        if (!gallowsService.win()) {
            return "redirect:/play";
        }
        return "win";
    }

}
