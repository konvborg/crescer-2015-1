package filmator.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErroController implements  ErrorController {

	
	@RequestMapping(value = "/error")
	public String home(Model model) {
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "error";
	}
}