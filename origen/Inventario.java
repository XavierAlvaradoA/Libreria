import java.util.ArrayList;
import java.util.Collections;
public class Inventario {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Libro> librosCaros;
	
	public void almacenar(Libro libro) {
		libros.add(libro);}
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;}}
		return null;}
	public void venderLibros(String isbn, int cantidad) {
		if(getLibrobyIsbn(isbn) == null) {
			System.out.println("\nEl codigo ingresado no existe\n");}
		else
			if(getLibrobyIsbn(isbn).getCantidad() >= cantidad) {
				System.out.println("\nVenta del libro: "+getLibrobyIsbn(isbn).getTitulo());
				System.out.println("Total a pagar: $"+
				getLibrobyIsbn(isbn).getPrecio()*cantidad);
				getLibrobyIsbn(isbn).setCantidad((getLibrobyIsbn(isbn).getCantidad() - cantidad));
				if(getLibrobyIsbn(isbn).getCantidad() == 0) {
					System.out.println("Con esta venta se agota el libro");
					libros.remove(libros.indexOf(getLibrobyIsbn(isbn)));
					}
			}
			else
				if(getLibrobyIsbn(isbn).getCantidad() < cantidad) {
					System.out.println("\nSolo hay "+getLibrobyIsbn(isbn).getCantidad()+" unidades\n");}
	}
	public void ordenarPrecios() {
		librosCaros = new ArrayList<Libro>();
		for(int i=0; i<libros.size(); i++) {
			librosCaros.add(libros.get(i));}
		Collections.sort(librosCaros, new PrecioMayor());
	}
	public ArrayList<Libro> getlibrosCaros() {
		for(int i=0; i<3; i++) {
			System.out.println(librosCaros.get(i));}
		return null;
	}
	public String getLibros() {
		for(int i=0; i<libros.size(); i++) {
			System.out.println(libros.get(i));}
		return null;}
}
