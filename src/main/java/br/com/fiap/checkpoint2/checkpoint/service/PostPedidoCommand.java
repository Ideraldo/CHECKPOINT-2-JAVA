package br.com.fiap.checkpoint2.checkpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommandPattern.UseCase;
import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.checkpoint.model.PedidoModel;
import br.com.fiap.checkpoint2.checkpoint.repository.PedidoRepository;

@Service
public class PostPedidoCommand implements UseCase {

	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoMapper mapper;
	
	PedidoDTO dto;
	
	PedidoModel pedidoSalvo;
		
	public PedidoDTO post(PedidoDTO dto) {
		this.dto = dto;
		try {
			this.Executar();
			return mapper.toPedidoDTO(pedidoSalvo);
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void Executar() {
		pedidoSalvo = repository.save(mapper.toPedidoModel(dto));
	}
	
}
