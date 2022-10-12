package br.com.fiap.checkpoint2.checkpoint.mapper;

import org.springframework.stereotype.Component;

import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.model.PedidoModel;

@Component
public class PedidoMapper {
	
	public PedidoModel toPedidoModel(PedidoDTO DTO) {
		return new PedidoModel(DTO.getDataPedido(), DTO.getCodigoCliente(), DTO.getDataCadastro(), DTO.getValorTotal());
	}
	
	public PedidoDTO toPedidoDTO(PedidoModel model) {
		return new PedidoDTO(model.getId(), model.getDataPedido(), model.getCodigoCliente(), model.getDataCadastro(), model.getValorTotal());
	}
	
	
}
