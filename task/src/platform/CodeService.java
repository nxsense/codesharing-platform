package platform;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }
    public Code getCodeById(Long id){
        return this.codeRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Map<String, String> createNewCode(Code code){
        var id = this.codeRepository
                .save(code)
                .getId();

        return Map.of("id", String.valueOf(id));
    }

    public List<Code> getLatestCodeSnippets(){
        return this.codeRepository.findTop10ByOrderByDateDesc();
    }
}
