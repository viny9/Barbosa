package com.example.barbosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServicePessoa implements Serializable {
    private static List<CadastroVO> listaPessoa;
    private static ServicePessoa servicePessoa = null;

    private ServicePessoa() {
        listaPessoa = new ArrayList<>();
    }

    public static ServicePessoa getInstance() {
        if (servicePessoa == null)
            servicePessoa = new ServicePessoa();

        return servicePessoa;
    }

    public void salvar(CadastroVO cadastroVO) {
        listaPessoa.add(cadastroVO);
    }

    public List<CadastroVO> getListaPessoa() {
        return listaPessoa;
    }
}
