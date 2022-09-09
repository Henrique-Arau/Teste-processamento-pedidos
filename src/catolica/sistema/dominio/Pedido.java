package catolica.sistema.dominio;

//-----------------------------------------------------
/** Classe que guarda os dados de um pedido */
//-----------------------------------------------------
public class Pedido {
	
	//-----------------------------------------------------
	/** Identificador de um objeto do tipo Pedido */
	//-----------------------------------------------------
	private Integer id ;
	
	//-----------------------------------------------------
	/** Valor do pedido, deve ser maior que zero */
	//-----------------------------------------------------
	private Double valorPedido ;
	
	//-----------------------------------------------------
	/** Estado do pedido */
	//-----------------------------------------------------
	private EstadoPedido estadoPedido ;

	//-----------------------------------------------------
	// Métodos get/set
	//-----------------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
}
