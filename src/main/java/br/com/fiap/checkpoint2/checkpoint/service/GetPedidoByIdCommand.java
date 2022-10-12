package br.com.fiap.checkpoint2.checkpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommandPattern.UseCase;
import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.checkpoint.model.PedidoModel;
import br.com.fiap.checkpoint2.checkpoint.repository.PedidoRepository;

@Service
public class GetPedidoByIdCommand implements UseCase {

	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoMapper mapper;
	
	PedidoModel pedido;
	Long id;
		
	public PedidoDTO get(Long id) {
		this.id = id;
		try {
			this.Executar();
			return mapper.toPedidoDTO(pedido);
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void Executar() {
		pedido = repository.getReferenceById(id);
	}
	
}
