package com.jpr.greendaodemo.bean;

import android.support.annotation.IntDef;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.jpr.greendaodemo.db.DaoSession;
import com.jpr.greendaodemo.db.IdCardDao;
import com.jpr.greendaodemo.db.StudentDao;

import java.util.List;
import com.jpr.greendaodemo.db.CreditCardDao;

/**
 * 类描述：
 * 创建日期：2019/7/17.
 * 作者：jiaopeirog
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private Long id2;
    private String name;
    private int age;

    //一对一（joinProperty的值是Student属性,该属性和IdCard的主键形成映射关系《IdCard的数据类型一定要和name属性一致》）
    //把属性设置成（关联表的）主键
    @ToOne(joinProperty = "name")
    private IdCard idCard;

    //一对多，这个studentId是对应在CreditCard中的studentId,值一般的是Student的主键
    //把主键设置成（关联表的）属性
    @ToMany(referencedJoinProperty = "studentId")
    List<CreditCard> creditCardsList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;

    @Generated(hash = 1790715216)
    public Student(Long id, Long id2, String name, int age) {
        this.id = id;
        this.id2 = id2;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Generated(hash = 137173928)
    private transient String idCard__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 797242429)
    public IdCard getIdCard() {
        String __key = this.name;
        if (idCard__resolvedKey == null || idCard__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IdCardDao targetDao = daoSession.getIdCardDao();
            IdCard idCardNew = targetDao.load(__key);
            synchronized (this) {
                idCard = idCardNew;
                idCard__resolvedKey = __key;
            }
        }
        return idCard;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 432650007)
    public void setIdCard(IdCard idCard) {
        synchronized (this) {
            this.idCard = idCard;
            name = idCard == null ? null : idCard.getUserName();
            idCard__resolvedKey = name;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1268960764)
    public List<CreditCard> getCreditCardsList() {
        if (creditCardsList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CreditCardDao targetDao = daoSession.getCreditCardDao();
            List<CreditCard> creditCardsListNew = targetDao
                    ._queryStudent_CreditCardsList(id);
            synchronized (this) {
                if (creditCardsList == null) {
                    creditCardsList = creditCardsListNew;
                }
            }
        }
        return creditCardsList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 441911208)
    public synchronized void resetCreditCardsList() {
        creditCardsList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

    public Long getId2() {
        return this.id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }


   
}
