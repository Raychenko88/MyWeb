package org.example.dao;


import org.example.model.Cart;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    /**
     * @param cart must be always open (closed = false)
     * @return stored cart with id
     */
    public static Cart create(Cart cart){
        String sql = "INSERT INTO carts(creation_time, closed, user_id) VALUES(?,?,?)";
        String sequenceSql = "SELECT currval(pg_get_serial_sequence('carts','id'))";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             PreparedStatement seqStatement = connection.prepareStatement(sequenceSql)
        ){
            preparedStatement.setLong(1, cart.getCreationTime());
            preparedStatement.setInt(2, cart.getClosed());
            preparedStatement.setInt(3, cart.getUserId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = seqStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                cart.setId(id);

                return cart;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static Cart update(Cart cart){
        String sql = "UPDATE carts SET closed=?, user_id=?, creation_time=? WHERE id=?";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1, cart.getClosed());
            preparedStatement.setInt(2, cart.getUserId());
            preparedStatement.setLong(3, cart.getCreationTime());
            preparedStatement.setInt(4, cart.getId());

            preparedStatement.executeUpdate();
            return cart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Cart findById(Integer id){
        String statement = "SELECT * FROM carts WHERE id=?";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cart cart = new Cart();

                cart.setId(resultSet.getInt("id"));
                cart.setCreationTime(resultSet.getLong("creation_time"));
                cart.setClosed(resultSet.getInt("closed"));
                cart.setUserId(resultSet.getInt("user_id"));

                return cart;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Cart> findByUser(User user){
        String sql = "SELECT * FROM carts WHERE user_id = ?";
        List<Cart> carts = new ArrayList<>();

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cart cart = new Cart();
                cart.setId(resultSet.getInt("id"));
                cart.setCreationTime(resultSet.getLong("creation_time"));
                cart.setClosed(resultSet.getInt("closed"));
                cart.setUserId(resultSet.getInt("user_id"));
                carts.add(cart);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return carts;
    }

    public static Cart findOpenCartByUser(Integer userId){
        String statement = "SELECT * FROM carts WHERE closed=0 AND user_id=?";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cart cart = new Cart();

                cart.setId(resultSet.getInt("id"));
                cart.setCreationTime(resultSet.getLong("creation_time"));
                cart.setClosed(resultSet.getInt("closed"));
                cart.setUserId(resultSet.getInt("user_id"));

                return cart;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void delete(Cart cart){
        String statement = "DELETE FROM carts WHERE id=?";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {

            preparedStatement.setInt(1, cart.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
