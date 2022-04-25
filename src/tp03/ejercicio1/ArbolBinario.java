package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho;
	
	/**
	 * Para dejar en claro que el constructor sin parámetros crea arboles vacíos.
	 */
	public static <A> ArbolBinario<A> arbolVacio(){
		return new ArbolBinario<>();
	}
	
	/**
	 *  Crea un árbol vacío.
	 */
	public ArbolBinario() {
	}

	/**
	 * Crea un árbol con un dato.  Si este es nulo, se lo considera vacío.
	 */
	public ArbolBinario(T dato) {
		this(dato, null, null);
	}
	
	/**
	 * Crea un árbol con un dato y dos hijos.
	 */
	public ArbolBinario(T dato, ArbolBinario<T> hi, ArbolBinario<T> hd) {
		this.dato = dato;
		this.agregarHijoIzquierdo(hi);
		this.agregarHijoDerecho(hd);
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;
	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo == null ? arbolVacio() : hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo == null ? arbolVacio() : hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = arbolVacio();
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = arbolVacio();
	}

	public boolean esVacio() {
		// alcanza con que cualquiera sea nulo.
		return this.hijoDerecho == null && this.hijoIzquierdo == null;
	}

	/**
	 * Retorna si es una hoja.  Esta operación falla para árboles vacíos.
	 */
	public boolean esHoja() {
		return !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}
	
	/**
	 * Indica si tiene un hijo del lado izquierdo.  Esta operación no está definida para árboles vacíos.
	 */
	public boolean tieneHijoIzquierdo() {
		return !this.hijoIzquierdo.esVacio();
	}
	
	/**
	 * Indica si tiene un hijo del lado izquierdo.  Esta operación no está definida para árboles vacíos.
	 */
	public boolean tieneHijoDerecho() {
		return !this.hijoDerecho.esVacio();
	}

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}
	
	// imprime el árbol en preorden  
	public void printPreorden() {
		
	}

	// imprime el árbol en postorden
	public void printPostorden() {
		
	}

	public void recorridoPorNiveles() {
		
	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();

		return l;
	}
	
	public int contarHojas() {
		return 0;
	}
}
