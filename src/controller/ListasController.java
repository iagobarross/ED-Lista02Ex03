package controller;

import model.*;

public class ListasController<T> {

	private boolean contains(ILista<T> lista, T valor) throws Exception {
		int tamanho = lista.size();

		try {
			for (int i = 0; i < tamanho; i++) {
				if (valor == lista.get(i)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return false;
	}

	public ILista<T> uniao(ILista<T> listaA, ILista<T> listaB) {
		ILista<T> listaU = new Lista<>();

		int tamanhoA = listaA.size();
		int tamanhoB = listaB.size();

		try {
			for (int i = 0; i < tamanhoA; i++) {
				listaU.addLast(listaA.get(i));
			}

			for (int i = 0; i < tamanhoB; i++) {
				if (!contains(listaU, listaB.get(i))) {
					listaU.addLast(listaB.get(i));
				} 
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listaU;

	}
	
	public ILista<T> interseccao(ILista<T> listaA, ILista<T> listaB){
		ILista<T> listaI = new Lista<>();
		
		int tamanho = listaA.size();
		try {
			for(int i = 0; i < tamanho; i++ ) {
				if(contains(listaB, listaA.get(i))) {
					listaI.addLast(listaA.get(i));
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return listaI;
	}

}
