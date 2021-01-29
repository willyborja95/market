package com.wborja.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Integer idCompra;
	
	@Column(name="id_cliente")
	private Integer idCliente;
	
	private LocalDateTime fecha;
	
	@Column(name="medio_pago")
	private Integer medioPago;
	
	private String comentario;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", insertable=false, updatable=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="producto", cascade= {CascadeType.ALL})
	private List<ComprasProducto> productos;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(Integer medioPago) {
		this.medioPago = medioPago;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ComprasProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<ComprasProducto> productos) {
		this.productos = productos;
	}
		
	
}
