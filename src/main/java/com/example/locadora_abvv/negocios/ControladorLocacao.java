package com.example.locadora_abvv.negocios;

import com.example.locadora_abvv.dados.IRepositorio;
import com.example.locadora_abvv.dados.Repositorio;
import com.example.locadora_abvv.exceptions.ElementoExisteException;
import com.example.locadora_abvv.exceptions.ElementoNaoExisteExcepcion;
import com.example.locadora_abvv.negocios.beans.Locacao;

public class ControladorLocacao {

    private IRepositorio<Locacao> repositorioLocacoes;
    private static ControladorLocacao instance;

    public ControladorLocacao() {
        this.repositorioLocacoes = new Repositorio<>("locacoes.dat");
    }

    public static ControladorLocacao getInstance(){
        if (instance == null)
            instance = new ControladorLocacao();
        return instance;
    }

    public void cadastrar(Locacao l) throws ElementoExisteException {
        this.repositorioLocacoes.cadastrar(l);
    }

    public void listar(){
        this.repositorioLocacoes.listar();
    }

    public void remover(Locacao l) throws ElementoNaoExisteExcepcion {
        this.repositorioLocacoes.remover(l);
    }

    public void atualizar(Locacao l) throws ElementoNaoExisteExcepcion {
        this.repositorioLocacoes.atualizar(l);
    }
}
