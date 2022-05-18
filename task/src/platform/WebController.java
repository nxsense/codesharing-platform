package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/code")
public class WebController {
    Code code;

    public WebController (@Autowired Code code){
        this.code = code;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getCode(Model model, HttpServletResponse response){
        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.dateTimeToString());
        response.addHeader("Content-Type", "text/html");
        return "code";
    }
    @GetMapping(value = "/new", produces = MediaType.TEXT_HTML_VALUE)
    public String getNewCode(){
        return "new-code";
    }
}
