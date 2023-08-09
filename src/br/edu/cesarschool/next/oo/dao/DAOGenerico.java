package br.edu.cesarschool.next.oo.dao;

import java.io.Serializable;


import br.edu.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOGenerico {
    private CadastroObjetos cadastro;
       
    public DAOGenerico(Class entidade) {
        cadastro = new CadastroObjetos(entidade);
    }
    public boolean incluir(RegistroIdentificavel reg) {
		RegistroIdentificavel contaBusca = buscar(reg.obterChave());
		if (contaBusca != null) {
			return false;
		} else {
			cadastro.incluir(reg, reg.obterChave());
			return true;
		}		
	}
	public boolean alterar(RegistroIdentificavel reg) {
		RegistroIdentificavel contaBusca = buscar(reg.obterChave());
		if (contaBusca == null) {
			return false;
		} else {
			cadastro.alterar(reg, reg.obterChave());
			return true;
		}		
	}
	public RegistroIdentificavel buscar(String numero) {
		return (RegistroIdentificavel)cadastro.buscar(numero);
	}
    public boolean excluir(String reg) {
		RegistroIdentificavel contaBusca = buscar(reg);
		if (contaBusca == null) {
			return false;
		} else {
			cadastro.excluir(reg);
			return true;
		}		
	}
    //lis<RegistroIndentificavel>buscarTodos
	public RegistroIdentificavel[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(RegistroIdentificavel.class);
		RegistroIdentificavel[] contas = new RegistroIdentificavel[rets.length];
		for(int i=0; i<rets.length; i++) {
			contas[i] = (RegistroIdentificavel)rets[i];
		}
		return contas;
	}
}
