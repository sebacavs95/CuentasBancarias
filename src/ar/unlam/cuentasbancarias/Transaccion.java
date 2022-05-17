package ar.unlam.cuentasbancarias;

import java.util.Date;

public class Transaccion {

	private Double monto;
	private TipoDeMotivos motivo;
	private Date fecha;

	public Transaccion(Double monto, TipoDeMotivos motivo, Date fecha) {
		this.monto = monto;
		this.motivo = motivo;
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public TipoDeMotivos getMotivo() {
		return motivo;
	}

	public void setMotivo(TipoDeMotivos motivo) {
		this.motivo = motivo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
