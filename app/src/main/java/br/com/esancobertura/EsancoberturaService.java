package br.com.esancobertura;

public class EsancoberturaService {
    private EsancoberturaDao dao;
    private EsancoberturaDaoRoom daoRoom;

    public EsancoberturaService(EsancoberturaDao dao, EsancoberturaDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }
}
