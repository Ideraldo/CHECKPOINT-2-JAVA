package br.com.fiap.checkpoint2.checkpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommandPattern.UseCase;
import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.checkpoint.model.PedidoModel;
import br.com.fiap.checkpoint2.checkpoint.repository.PedidoRepository;

@Service
public class GetAllPedidosCommand implements UseCase{

	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoMapper mapper;
	
	List<PedidoModel> listPedidos;
		
	public List<PedidoDTO> get() {		
		try {
			this.Executar();
			return listPedidos.stream().map(p -> mapper.toPedidoDTO(p)).toList();
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void Executar() {
		listPedidos = repository.findAll();
	}
	
}
