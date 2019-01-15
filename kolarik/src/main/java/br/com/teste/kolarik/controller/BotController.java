package br.com.teste.kolarik.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.kolarik.model.Bot;
import br.com.teste.kolarik.repository.BotRepository;

@RestController
@RequestMapping("/bots")
public class BotController {
	
	@Autowired
	BotRepository repository; 
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Bot> getAllBots(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Bot getBotById(@PathVariable("id") ObjectId id){
		return repository.findById(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public void modifyBotById(@PathVariable("id") ObjectId id, @Valid @RequestBody Bot bot){
		bot.setId(id);
		repository.save(bot);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Bot createBot(@Valid @RequestBody Bot bot) {
	  bot.setId(ObjectId.get());
	  repository.save(bot);
	  return bot;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteBot(@PathVariable ObjectId id) {
	  repository.delete(repository.findById(id));
	}
	
}
