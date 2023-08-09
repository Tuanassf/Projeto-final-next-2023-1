package br.edu.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOContaCorrente {
    private CadastroObjetos cadastro = new CadastroObjetos(ContaCorrente.class);
	private DAOGenerico dao = new DAOGenerico(ContaCorrente.class);
    public boolean incluir(ContaCorrente conta) {
		return dao.incluir(conta); //delega funçao para o DAO
	}
	public boolean alterar(ContaCorrente conta) {
		return dao.alterar(conta); //delega funçao para o DAO
	}
	public ContaCorrente buscar(String numero) {
		return (ContaCorrente)dao.buscar(numero);
	}
    //lis<ContaCorrente>buscarTodos
	public ContaCorrente[] buscarTodos() {
		RegistroIdentificavel[] rets = dao.buscarTodos();
		ContaCorrente[] contas = new ContaCorrente[rets.length];
		for(int i=0; i<rets.length; i++) {
			contas[i] = (ContaCorrente)rets[i];
		}
		return contas;
	}

	public boolean excluir(String numero) {
		return dao.excluir(numero);
	}
}
