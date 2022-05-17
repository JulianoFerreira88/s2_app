package br.com.esanaraca;

import br.com.utils.RetrofitBuilder;

public class EsanracaService {
    private EsanracaDao dao;
    private EsanracaDaoRoom daoRoom;

    public EsanracaService(EsanracaDao dao, EsanracaDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }

    public EsanracaDao getDao() {
        return RetrofitBuilder.build().create(EsanracaDao.class);
    }
}
