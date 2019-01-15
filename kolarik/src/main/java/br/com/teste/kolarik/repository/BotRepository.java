package br.com.teste.kolarik.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.teste.kolarik.model.Bot;

public interface BotRepository extends MongoRepository<Bot, String>{
	Bot findById(ObjectId id);
}
