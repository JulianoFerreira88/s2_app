package br.com.esanmatriz;

public class EsanmatrizService {
    private EsanmatrizDao dao;
    private EsanmatrizDaoRoom daoRoom;

    public EsanmatrizService(EsanmatrizDao dao, EsanmatrizDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }

    
}
