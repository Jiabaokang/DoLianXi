import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class getCookies {
    @RequestMapping("/getCookie")
    public String getcookie(){
        return "getCookies成功！";
    }
}
