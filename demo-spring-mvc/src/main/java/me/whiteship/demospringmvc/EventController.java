package me.whiteship.demospringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/events")
	public String events(Model model) {
		
		model.addAttribute("events", eventService.getEvents());
		
		// github 다른장소에서 커밋 테스트 2010.05.10 
		
		return "events";
	}
}
