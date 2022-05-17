package br.com.esanfuncionario;

public class EsanfuncionarioService {
    private EsanfuncionarioDao dao;
    private EsanfuncionarioDaoRoom daoRoom;

    public EsanfuncionarioService(EsanfuncionarioDao dao, EsanfuncionarioDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }
}
