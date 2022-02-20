package dao;

import utils.Route;

import java.util.Deque;
import java.util.Map;

public interface DAO {
    void create(Route route);
    void update(int id, Route route);
    void delete(Route id);
    Route get(int id);
    Deque<Route> getAll();
    int clear();
    Map<String, String> getDescription();
}
