package br.com.fiap.checkpoint2.checkpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommandPattern.UseCase;
import br.com.fiap.checkpoint2.checkpoint.repository.PedidoRepository;

@Service
public class DeletePedidoCommand implements UseCase {

	
	@Autowired
	PedidoRepository repository;
	
	Long id;
		
	public void delete(Long id) {
		this.id = id;
		try {
			this.Executar();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void Executar() {
		repository.deleteById(id);
	}
	
}
