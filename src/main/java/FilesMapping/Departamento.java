package FilesMapping;
// Generated 21-abr-2021 16:34:38 by Hibernate Tools 5.4.14.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Departamento implements java.io.Serializable {

	@Id
	@Column(name = "CODIGO")
	private int codigo;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "COD_RESPONSABLE")
	private int codResponsable;

	public Departamento() {
	}

	public Departamento(int codigo, String nombre, int codResponsable) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.codResponsable = codResponsable;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodResponsable() {
		return this.codResponsable;
	}

	public void setCodResponsable(int codResponsable) {
		this.codResponsable = codResponsable;
	}

}
