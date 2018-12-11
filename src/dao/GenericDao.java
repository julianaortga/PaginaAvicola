package dao;

import java.util.List;

public interface GenericDao<T> {
	public List<T> list();
	public <E> T find(E id);
	public boolean insert(T o);
	public boolean update(T o);
	public boolean delete(T o);
}