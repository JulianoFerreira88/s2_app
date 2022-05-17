package br.com.esandesmamesparciais;

public class EsandesmamesparciaisService {
    private EsandesmamesparicaisDaoRoom daoRoom;
    private EsandesmamesparciaisDao dao;

    public EsandesmamesparciaisService(EsandesmamesparicaisDaoRoom daoRoom, EsandesmamesparciaisDao dao) {
        this.daoRoom = daoRoom;
        this.dao = dao;
    }
}
