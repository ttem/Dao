package com.ttem.dao;

import com.ttem.data.*;
import org.easymock.EasyMock;

import java.util.List;

public class Dao implements DaoInterface{

    private final static SourceType DEFAULT_SOURCE_TYPE = SourceType.DATA_BASE;
    private final static Dao daoInstance = new Dao();

    private SourceType sourceType;
    private Data data;

    public static Dao getInstance() {
        return daoInstance;
    }

    private Dao() {
        this.setSourceOfData(Dao.DEFAULT_SOURCE_TYPE);
    }

    public boolean setSourceOfData(final SourceType sourceType){
        switch (sourceType){
            case DATA_BASE:
                this.data = new DataBase();
                break;
            case WEB_SERVICE:
                this.data = new WebService();
                break;
            case XML:
                this.data = new Xml();
                break;
            default:
                try {
                    throw new Exception("Unknow source type");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        this.sourceType = sourceType;

        return true;
    }

    public User selectUserById(final int id) {
        return this.data.selectUserById(id);
    }

    public List<User> selectAllUsers() {
        return this.data.selectAllUsers();
    }

    public SourceType getSourceType() {
        return sourceType;
    }
}
