package br.com.esandesmame;

public class EsandesmameService {
    private EsandesmameDao dao;
    private EsandesmameDaoRoom daoRoom;

    public EsandesmameService(EsandesmameDao dao, EsandesmameDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }
}
