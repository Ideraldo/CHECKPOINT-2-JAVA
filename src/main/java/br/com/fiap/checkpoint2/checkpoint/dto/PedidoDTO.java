package br.com.fiap.checkpoint2.checkpoint.dto;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class PedidoDTO {

	private Long id;
	private Instant dataPedido;
	private Long codigoCliente;
	private Instant dataCadastro;
	private BigDecimal valorTotal;

	public PedidoDTO() {
		
	}
	
	public PedidoDTO(Long id, Instant dataPedido, Long codigoCliente, Instant dataCadastro, BigDecimal valorTotal) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.codigoCliente = codigoCliente;
		this.dataCadastro = dataCadastro;
		this.valorTotal = valorTotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Instant getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
