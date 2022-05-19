package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/code")
public class WebController {
    private final CodeService  codeService;


    public WebController(CodeService codeService){
        this.codeService = codeService;
    }


    @GetMapping("/{id}")
    public String getCode(@PathVariable long id, Model model) {
        model.addAttribute("title", "Code");
        model.addAttribute("code", List.of(this.codeService.getCodeById(id)));
        return "code";
    }

    @GetMapping("/latest")
    public String getLatestCode(Model model) {
        model.addAttribute("title", "Latest");
        model.addAttribute("code", this.codeService.getLatestCodeSnippets());
        return "code";
    }
    @GetMapping("/new")
    public String newCode() {
        return "newCode";
    }

    @PostMapping("/new")
    public String processNewCode() {
        return "redirect:/code/new";
    }
}
