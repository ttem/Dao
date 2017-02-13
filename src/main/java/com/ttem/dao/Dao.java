package com.ttem.dao;

import com.ttem.data.Data;
import com.ttem.data.DataBase;
import com.ttem.data.SourceType;
import com.ttem.data.WebService;
import com.ttem.data.Xml;
import com.ttem.exception.SourceTypeNotDefinedException;
import org.apache.log4j.Logger;
import java.util.List;

public class Dao implements DaoInterface{

    private final static Logger log = Logger.getLogger(Dao.class);
    private final static SourceType DEFAULT_SOURCE_TYPE = SourceType.DATA_BASE;

    private SourceType sourceType;
    private Data data;

    public Dao() {
        this.setSourceOfData(Dao.DEFAULT_SOURCE_TYPE);
    }

    public boolean setSourceOfData(final SourceType sourceType) {
        switch (sourceType){
            case DATA_BASE:
                this.data = DataBase.getInstance();
                break;
            case WEB_SERVICE:
                this.data = WebService.getInstance();
                break;
            case XML:
                this.data = Xml.getInstance();
                break;
            default:
                try {
                    throw new SourceTypeNotDefinedException(sourceType.toString());
                } catch (SourceTypeNotDefinedException e) {
                    log.error(e.toString());
                    return false;
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

    public static SourceType getDefaultSourceType() {
        return Dao.DEFAULT_SOURCE_TYPE;
    }

    public SourceType getSourceType() {
        return this.sourceType;
    }

    public Data getData() {
        return this.data;
    }
}
