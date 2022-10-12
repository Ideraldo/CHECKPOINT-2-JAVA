package br.com.fiap.checkpoint2.checkpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CommandPattern.UseCase;
import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.mapper.PedidoMapper;
import br.com.fiap.checkpoint2.checkpoint.model.PedidoModel;
import br.com.fiap.checkpoint2.checkpoint.repository.PedidoRepository;

@Service
public class PutPedidoCommand implements UseCase{
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoMapper mapper;
	
	PedidoModel pedidoAtualizado;
	
	PedidoDTO dto;
	Long id;
		
	public PedidoDTO put(PedidoDTO dto, Long id) {
		this.dto = dto;
		this.id = id;
		try {
			this.Executar();
			return mapper.toPedidoDTO(pedidoAtualizado);
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void Executar() {
		PedidoModel pedidoParaSalvar = mapper.toPedidoModel(dto);
		pedidoParaSalvar.setId(id);
		pedidoAtualizado = repository.save(pedidoParaSalvar);
	}
	
}
