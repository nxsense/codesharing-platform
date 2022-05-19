package platform;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class APIController {
    Code code;
   private final CodeService codeService;

    public APIController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCode (@PathVariable("id") Long id){
        return ResponseEntity.ok(this.codeService.getCodeById(id));
    }
    @GetMapping("/latest")
    public ResponseEntity<?> getLatestCode(){
        return ResponseEntity.ok(this.codeService.getLatestCodeSnippets());
    }
    @PostMapping("/new")
    public ResponseEntity<?> submitCode(@RequestBody Code code){
        return ResponseEntity.ok(this.codeService.createNewCode(code));
    }
}
