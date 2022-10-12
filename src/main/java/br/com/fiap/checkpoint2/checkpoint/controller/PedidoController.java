package br.com.fiap.checkpoint2.checkpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.checkpoint.dto.PedidoDTO;
import br.com.fiap.checkpoint2.checkpoint.service.DeletePedidoCommand;
import br.com.fiap.checkpoint2.checkpoint.service.GetAllPedidosCommand;
import br.com.fiap.checkpoint2.checkpoint.service.GetPedidoByIdCommand;
import br.com.fiap.checkpoint2.checkpoint.service.PostPedidoCommand;
import br.com.fiap.checkpoint2.checkpoint.service.PutPedidoCommand;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private DeletePedidoCommand deletePedidoService;
	
	@Autowired
	private GetAllPedidosCommand getAllPedidosService;
	
	@Autowired
	private GetPedidoByIdCommand getPedidoByIdService;
	
	@Autowired
	private PostPedidoCommand postPedidoService;
	
	@Autowired
	private PutPedidoCommand putPedidoService;
		
	@PostMapping
	public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedidoDTO) {
		
		PedidoDTO pedidoSalvo = postPedidoService.post(pedidoDTO);
		return ResponseEntity.ok(pedidoSalvo);
	}

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> get(){
		return ResponseEntity.ok(getAllPedidosService.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(getPedidoByIdService.get(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		deletePedidoService.delete(id);
		return ResponseEntity.ok("Pedido apagado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> put(@RequestBody PedidoDTO pedidoDTO, @PathVariable Long id){
		PedidoDTO pedidoAtualizado = putPedidoService.put(pedidoDTO, id);
		return ResponseEntity.ok(pedidoAtualizado);
	}
	
	
}
