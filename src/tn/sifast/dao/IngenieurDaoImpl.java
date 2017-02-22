package tn.sifast.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.sifast.bean.Ingenieur;

public class IngenieurDaoImpl implements IngenieurDao {

	
	DaoFactory daoFactory;
	
	public IngenieurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public List<Ingenieur> getAll() {
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		List<Ingenieur> list=new ArrayList<Ingenieur>();
		try{
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			result=statement.executeQuery("select * from ingenieur");
			while(result.next()){
				  Ingenieur r=new Ingenieur(result.getInt(1),result.getString(2),result.getString(3));
				  list.add(r);
			}
		}catch(Exception e){e.printStackTrace();  }
		finally{
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {	e.printStackTrace();}
			
			}
		
		return list;
		
	}

	@Override
	public Ingenieur get(int id) {
		Connection connection=null;
		Statement statement=null;
		ResultSet result=null;
		try{
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			result=statement.executeQuery("select * from ingenieur where id="+id);
			while(result.next()){
				  Ingenieur r=new Ingenieur(result.getInt(1),result.getString(2),result.getString(3));
				  return r;
			}
		}catch(Exception e){e.printStackTrace();  }
		finally{
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {	e.printStackTrace();}
			
			}
		return null;
	}

	@Override
	public int creerIngenieur(Ingenieur b) {
		Connection connection=null;
		java.sql.PreparedStatement pst=null;
		try{
			String sql="INSERT INTO `ingenieur`(`id`, `nom`, `prenom`) VALUES (NULL,?,?)";
			connection=daoFactory.getConnection();
			pst=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,b.getNom());
			pst.setString(2, b.getPrenom());

            pst.executeUpdate();
            
            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
			
		}catch(Exception e){e.printStackTrace();return -1; }
		finally{
			try {
				connection.close();
				pst.close();
			} catch (SQLException e) {	e.printStackTrace();}
			
			}
		
		
	}

	@Override
	public int delete(int id) {
		Connection connection=null;
		java.sql.PreparedStatement pst=null;
		try{
			String sql="DELETE FROM `ingenieur` WHERE id=?";
			connection=daoFactory.getConnection();
			pst=connection.prepareStatement(sql);
			
			pst.setInt(1, id);

          return  pst.executeUpdate();
			
		}catch(Exception e){e.printStackTrace();return -1; }
		finally{
			try {
				connection.close();
				pst.close();
			} catch (SQLException e) {	e.printStackTrace();}
			
			}
		
	}

	@Override
	public int update(String nom,String prenom, int id) {
		Connection connection=null;
		java.sql.PreparedStatement pst=null;
		try{
			String sql="UPDATE `ingenieur` SET `nom`=?,`prenom`=? WHERE id=?";
			connection=daoFactory.getConnection();
			pst=connection.prepareStatement(sql);
			
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setInt(3, id);

          return  pst.executeUpdate();
			
		}catch(Exception e){e.printStackTrace();return -1; }
		finally{
			try {
				connection.close();
				pst.close();
			} catch (SQLException e) {	e.printStackTrace();}
			
			}
	}

}
