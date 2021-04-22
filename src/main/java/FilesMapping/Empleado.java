package FilesMapping;
// Generated 21-abr-2021 16:34:38 by Hibernate Tools 5.4.14.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Empleado implements java.io.Serializable {

	@Id
	@Column(name = "CODIGO")
	private int codigo;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO1", nullable = false)
	private String apellido1;
	@Column(name = "APELLIDO2", nullable = false)
	private String apellido2;
	@Column(name = "LUGAR_NACIMIENTO", nullable = false)
	private String lugarNacimiento;
	@Column(name = "FECHA_NACIMIENTO", nullable = false)
	private String fechaNacimiento;
	@Column(name = "DIRECCION", nullable = false)
	private String direccion;
	@Column(name = "TELEFONO", nullable = false)
	private String telefono;
	@Column(name = "PUESTO", nullable = false)
	private String puesto;
	@Column(name = "COD_DEPARTAMENTO", nullable = false)
	private int codDepartamento;

	public Empleado() {
	}

	public Empleado(int codigo, String nombre, String apellido1, String apellido2, String lugarNacimiento,
			String fechaNacimiento, String direccion, String telefono, String puesto, int codDepartamento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.lugarNacimiento = lugarNacimiento;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.puesto = puesto;
		this.codDepartamento = codDepartamento;
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

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getCodDepartamento() {
		return this.codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", apellido1=" + apellido1+"]";
	}

}
