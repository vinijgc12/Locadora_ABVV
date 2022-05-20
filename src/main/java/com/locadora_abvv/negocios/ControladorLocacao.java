package com.locadora_abvv.negocios;

import com.locadora_abvv.dados.IRepositorio;
import com.locadora_abvv.dados.Repositorio;
import com.locadora_abvv.exceptions.ElementoExisteException;
import com.locadora_abvv.exceptions.ElementoNaoExisteExcepcion;
import com.locadora_abvv.negocios.beans.Fabricante;
import com.locadora_abvv.negocios.beans.Locacao;
import com.locadora_abvv.negocios.beans.Cliente;
import java.util.List;

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
        boolean ok = true;
        for(Locacao locacao : this.repositorioLocacoes.listar()){
            if(locacao == l){
                ok = false;
            }
            break;
        }
        if(ok) {
            boolean okey = true;
            for(Locacao loc : this.repositorioLocacoes.listar()){
                if(loc.getCliente() == l.getCliente()){
                    if(loc.getAtivo() == true){
                        okey = false;
                    }
                    break;
                }
            }

            if(okey) {
                this.repositorioLocacoes.cadastrar(l);
            }
            else{
                throw new IllegalArgumentException("ERRO: Cliente já possui uma locação ativa");
            }
        }
        else{
            throw new ElementoExisteException(l);
        }

    }

    public void listar(){
        this.repositorioLocacoes.listar();
    }


    public void atualizar(Locacao l) throws ElementoNaoExisteExcepcion {
        this.repositorioLocacoes.atualizar(l);
    }

    public void finalizarLocacao(Locacao l){
        l.calcularValorTotal(l.getVeiculo());
        l.setAtivo(false);
    }
}
