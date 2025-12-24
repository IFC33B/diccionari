import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/diccionari")
public class DiccionariController {
    @GetMapping("/terme")
    public String getMethodName(@PathVariable String terme) {
        return new String();
    }

    @PostMapping()
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
}
