package io;

import java.util.Comparator;

import domain.Usuario;

public class ComparadorRankingSubita implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return (o1.getPuntuacionSubita() - o2.getPuntuacionSubita()) * -1;
	}

}
