package io;

import java.util.Comparator;

import domain.Usuario;

public class ComparadorRankingClasico implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return (o1.getPuntuacionClasico() - o2.getPuntuacionClasico()) * -1;
	}
	
}
