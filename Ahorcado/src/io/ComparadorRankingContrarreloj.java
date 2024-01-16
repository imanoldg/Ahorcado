package io;

import java.util.Comparator;

import domain.Usuario;

public class ComparadorRankingContrarreloj implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return (o1.getPuntuacionContrarreloj() - o2.getPuntuacionContrarreloj()) * -1;
	}

}
