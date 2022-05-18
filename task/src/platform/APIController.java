package platform;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/code")
public class APIController {
    Code code;
    public APIController(@Autowired Code code){
        this.code = code;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Code> getCode(){
        return ResponseEntity.ok().
                header("Content-Type", "application/json")
                .body(code);
    }

    @PostMapping("/new")
    @ResponseBody
    public EmptyJson setCode(@RequestBody Map<String, String> codeJSON, Model model){
        code.setCode(codeJSON.get("code"));
        code.setDateTime(LocalDateTime.now());

        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.dateTimeToString());

        return new EmptyJson();
    }

    @JsonSerialize
    static class EmptyJson {
    }
}
