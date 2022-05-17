package br.com.esanparto;

public class EsanpartoService {
    private EsanpartoDao dao;
    private EsanpartoDaoRoom daoRoom;

    public EsanpartoService(EsanpartoDao dao, EsanpartoDaoRoom daoRoom) {
        this.dao = dao;
        this.daoRoom = daoRoom;
    }
}
