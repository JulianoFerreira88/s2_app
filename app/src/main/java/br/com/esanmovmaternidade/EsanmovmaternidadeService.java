package br.com.esanmovmaternidade;

public class EsanmovmaternidadeService {
    private EsanmovmaternidadeDao dao;
    private EsanmovmaternidadeDaoRoom daoRoom;

    public EsanmovmaternidadeService(EsanmovmaternidadeDao dao, EsanmovmaternidadeDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }
}
