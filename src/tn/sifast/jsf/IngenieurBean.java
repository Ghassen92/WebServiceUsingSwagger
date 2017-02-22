package tn.sifast.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.sifast.bean.Ingenieur;
import tn.sifast.dao.DaoFactory;
import tn.sifast.dao.IngenieurDao;

@ManagedBean
@SessionScoped
public class IngenieurBean implements Serializable	 {
private static final long serialVersionUID = 1L;
    
    private List<Ingenieur> list;
    private Ingenieur item = new Ingenieur();
    private Ingenieur beforeEditItem = null;
    private boolean edit;
    private DaoFactory dao;
    private IngenieurDao ingenieurDao;
    
    @PostConstruct
    public void init() {
        dao=DaoFactory.getInstance();
        ingenieurDao=dao.getIngenieurDao();
        list=ingenieurDao.getAll();
    }
    
    public void add() {
        ingenieurDao.creerIngenieur(item);
        updateList();
        item = new Ingenieur();
    }
    
    public void resetAdd() {
        item = new Ingenieur();
        updateList();
    }
    
    public void edit(Ingenieur item) {
        beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }
    
    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new Ingenieur();
        edit = false;
    }
    
    public void saveEdit() {
        ingenieurDao.update(beforeEditItem.getNom(),beforeEditItem.getPrenom(), item.getId());
        this.item = new Ingenieur();
        edit = false;
        updateList();
    }
    
    public void delete(Ingenieur item) throws IOException {
        ingenieurDao.delete(item.getId());
        updateList();
    }
    
    public List<Ingenieur> getList() {
        return list;
    }
    
    public Ingenieur getItem() {
        return this.item;
    }
    
    public boolean isEdit() {
        return this.edit;
    }
    
    private void updateList(){
    	list=ingenieurDao.getAll();
    }
}

