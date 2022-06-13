package its.rizzoli.PrimoProgetto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {
    @RequestMapping(value="/greeting")
    public String getIndex(){
        return "greeting";
    }
    @RequestMapping(value = "/home")
    public String getHome(){
        return "homepage";
    }
    @RequestMapping(value = "/book/{bookID}")
    public String getBook(@PathVariable("bookID") int id){
        System.out.println("Requested book id " + id);
        return "homepage";
    }
    @RequestMapping(value = "/book")
    public String getBookByParam(@RequestParam("bookID") int id){
        System.out.println("Requested book id " + id);
        return "homepage";
    }
    @GetMapping("/calculator")
    public String greeting(@RequestParam(value = "val1") int val1,
                           @RequestParam(value = "operation") String operation,
                           @RequestParam(value = "val2") int val2,
                           Model model){
        model.addAttribute("num1", val1);
        model.addAttribute("num2", val2);
        int result = 0;
        switch (operation){
            case "sum": {
                result = val1 + val2;
                operation = "+";
                break;
            }
            case "sub": {
                result = val1 - val2;
                operation = "-";
                break;
            }
            case "mul": {
                result = val1 * val2;
                operation = "*";
                break;
            }
            case "div": {
                result = val1 / val2;
                operation = "/";
                break;
            }
            case "pow": {
                result = (int) Math.pow(val1, val2);
                operation = "^";
                break;
            }
            default: {
                break;
            }
        }
        model.addAttribute("operator", operation);
        model.addAttribute("result", result);
        return "calculator";
    }
}
