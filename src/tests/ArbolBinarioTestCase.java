package tests;



import org.junit.Test;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio1.utils.ArbolBinarioExamples;

class ArbolBinarioTestCase {

	private ArbolBinario<Integer> ab;

	@BeforeEach
	void setUp() throws Exception {
		this.ab=new ArbolBinario<Integer>(1);
		ArbolBinario<Integer>  ab_hi_n1=new ArbolBinario<Integer>(2);
		ArbolBinario<Integer>  ab_hd_n1=new ArbolBinario<Integer>(3);
		ab.agregarHijoIzquierdo(ab_hi_n1);
		ab.agregarHijoDerecho(ab_hd_n1);
		
		ArbolBinario<Integer>  hi_hi_n2=new ArbolBinario<Integer>(4);
		ArbolBinario<Integer>  hi_hd_n2=new ArbolBinario<Integer>(5);
		
		ab_hi_n1.agregarHijoIzquierdo(hi_hi_n2);
		ab_hi_n1.agregarHijoDerecho(hi_hd_n2);
		
		
		ArbolBinario<Integer>  hd_hi_n2=new ArbolBinario<Integer>(6);
		ArbolBinario<Integer>  hd_hd_n2=new ArbolBinario<Integer>(7);
		ab_hd_n1.agregarHijoIzquierdo(hd_hi_n2);
		ab_hd_n1.agregarHijoDerecho(hd_hd_n2);
		
		
		
		hd_hd_n2.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		hi_hi_n2.agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		
		/*
		 *            1
		 *          /  \
		 *         2    3
		 *       /  \   /  \
		 *      4    5 6    7
		 *     /             \
		 *    10              8
		 * 
		 * */
		
		
		
	}

	@Test
	void testRecorridoPreorder() {
		ListaGenerica<Integer> lista_esperada = new ListaEnlazadaGenerica<Integer>();
		lista_esperada.agregarFinal(1);
		lista_esperada.agregarFinal(2);
		lista_esperada.agregarFinal(4);
		lista_esperada.agregarFinal(10);
		lista_esperada.agregarFinal(5);
		lista_esperada.agregarFinal(3);
		lista_esperada.agregarFinal(6);
		lista_esperada.agregarFinal(7);
		lista_esperada.agregarFinal(8);
		
		ArbolBinarioExamples<Integer> arbol_examples = new ArbolBinarioExamples<Integer>();
		assertEquals(lista_esperada, arbol_examples.preorder(this.ab));
	}
	
	@Test
	void testRecorridoInorder() {
		ListaGenerica<Integer> lista_esperada = new ListaEnlazadaGenerica<Integer>();
		lista_esperada.agregarFinal(1);
		lista_esperada.agregarFinal(2);
		lista_esperada.agregarFinal(3);
		lista_esperada.agregarFinal(4);
		lista_esperada.agregarFinal(5);
		lista_esperada.agregarFinal(6);
		lista_esperada.agregarFinal(7);
		lista_esperada.agregarFinal(10);
		lista_esperada.agregarFinal(8);
		
		ArbolBinarioExamples<Integer> arbol_examples = new ArbolBinarioExamples<Integer>();
		assertEquals(lista_esperada, arbol_examples.porNiveles(this.ab));
	}
	
	@Test
	void testRecorridoPostorder() {
		ListaGenerica<Integer> lista_esperada = new ListaEnlazadaGenerica<Integer>();
		lista_esperada.agregarFinal(10);
		lista_esperada.agregarFinal(4);
		lista_esperada.agregarFinal(5);
		lista_esperada.agregarFinal(2);
		lista_esperada.agregarFinal(6);
		lista_esperada.agregarFinal(8);
		lista_esperada.agregarFinal(7);
		lista_esperada.agregarFinal(3);
		lista_esperada.agregarFinal(1);
		
		ArbolBinarioExamples<Integer> arbol_examples = new ArbolBinarioExamples<Integer>();
		assertEquals(lista_esperada, arbol_examples.postorder(this.ab));
	}
	
	@Test
	void testRecorridoPorNiveles() {
		ListaGenerica<Integer> lista_esperada = new ListaEnlazadaGenerica<Integer>();
		lista_esperada.agregarFinal(1);
		lista_esperada.agregarFinal(2);
		lista_esperada.agregarFinal(3);
		lista_esperada.agregarFinal(4);
		lista_esperada.agregarFinal(5);
		lista_esperada.agregarFinal(6);
		lista_esperada.agregarFinal(7);
		lista_esperada.agregarFinal(10);
		lista_esperada.agregarFinal(8);
		
		ArbolBinarioExamples<Integer> arbol_examples = new ArbolBinarioExamples<Integer>();
		assertEquals(lista_esperada, arbol_examples.porNiveles(this.ab));
	}
	
	@Test
	void testContarHojas() {
		ArbolBinarioExamples<Integer> arbol_examples = new ArbolBinarioExamples<Integer>();
		assertEquals(4, arbol_examples.contarHojas(this.ab));
		
	}
}
