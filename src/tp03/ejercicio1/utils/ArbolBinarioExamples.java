package tp03.ejercicio1.utils;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ArbolBinarioExamples<T> {
	
	public ListaGenerica<T> preorder(ArbolBinario<T> arbol){
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.preorder_private(arbol, result);
		return result;
	}
	
	private void preorder_private(ArbolBinario<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()) {
			result.agregarFinal(arbol.getDato());
			this.preorder_private(arbol.getHijoIzquierdo(), result);
			this.preorder_private(arbol.getHijoDerecho(), result);
		}
	}
	
	public ListaGenerica<T> inorder(ArbolBinario<T> arbol){
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.inorder_private(arbol, result);
		return result;
	}
	
	private void inorder_private(ArbolBinario<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()) {
			this.inorder_private(arbol.getHijoIzquierdo(), result);
			result.agregarFinal(arbol.getDato());
			this.inorder_private(arbol.getHijoDerecho(), result);
		}
	}
	
	public ListaGenerica<T> postorder(ArbolBinario<T> arbol){
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.postorder_private(arbol, result);
		return result;
	}
	
    private void postorder_private(ArbolBinario<T> arbol, ListaGenerica<T> result) {
    	if (!arbol.esVacio()){
			this.postorder_private(arbol.getHijoIzquierdo(), result);
			this.postorder_private(arbol.getHijoDerecho(), result);
			result.agregarFinal(arbol.getDato());
    	}
	}
    
    public ListaGenerica<T> porNiveles(ArbolBinario<T> arbol){
    	ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
    	
    	if (!arbol.esVacio()) {
	    	ListaGenerica<ArbolBinario<T>> cola = new ListaEnlazadaGenerica<ArbolBinario<T>>();
	    	ArbolBinario<T> arbol_encolado;
	    	
	    	cola.agregarFinal(arbol);
	   		while(!cola.esVacia()) {
	    		arbol_encolado = cola.elemento(1);
	    		cola.eliminarEn(1);
				result.agregarFinal(arbol_encolado.getDato());
				if (arbol_encolado.tieneHijoIzquierdo())
					cola.agregarFinal(arbol_encolado.getHijoIzquierdo());
				if (arbol_encolado.tieneHijoDerecho())
					cola.agregarFinal(arbol_encolado.getHijoDerecho());
	    	}
    	}
    	return result;
    }

    public int contarHojas(ArbolBinario<T> arbol) {
    	int hojas = 0;
    	if (!arbol.esVacio()) {
	    	if (arbol.esHoja()) {
	    		hojas++;
	    	}
	    	else {
    			hojas = hojas + this.contarHojas(arbol.getHijoIzquierdo());
    			hojas = hojas + this.contarHojas(arbol.getHijoDerecho());
	    	}
    	}
    	return hojas;
    }
}

