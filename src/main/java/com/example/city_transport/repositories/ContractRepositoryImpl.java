package com.example.city_transport.repositories;

import com.example.city_transport.models.Contract;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
@Component
public class ContractRepositoryImpl implements ContractRepository{
    @Override
    public List<Contract> findAll(Connection connection) {
        List<Contract> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM contract
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Contract contract = new Contract();
                contract.setId(rs.getInt("id_contract"));
                contract.setFirm(rs.getString("firm"));
                contract.setDateStartContract(rs.getDate("datee"));
                contract.setDateEndContract(rs.getDate("validity"));
                contract.setTransportCount(rs.getInt("transport_count"));
                contract.setTypeTransport(rs.getString("type_transport"));
                listResult.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public void save(Contract contract, Connection connection) throws SQLException {
        java.util.Date utilPackageDate
                = contract.getDateStartContract();
        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        java.util.Date utilPackageDate1
                = contract.getDateEndContract();
        java.sql.Date sqlDate1 = new java.sql.Date(utilPackageDate1.getTime());
        String query = """
                       INSERT INTO contract
                       VALUES(?,?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, contract.getId());
            stmt.setString(2, contract.getFirm());
            stmt.setDate(3, sqlDate);
            stmt.setDate(4, sqlDate1);
            stmt.setInt(5, contract.getTransportCount());
            stmt.setString(6, contract.getTypeTransport());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id, Connection connection) {
        String query = """
                        DELETE FROM contract
                        WHERE id_contract = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Contract findById(int id, Connection connection) {
        Contract contract = new Contract();
        String query = """
                        SELECT *
                        FROM contract
                        WHERE id_contract = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                contract.setId(rs.getInt("id_contract"));
                contract.setFirm(rs.getString("firm"));
                contract.setDateStartContract(rs.getDate("datee"));
                contract.setDateEndContract(rs.getDate("validity"));
                contract.setTransportCount(rs.getInt("transport_count"));
                contract.setTypeTransport(rs.getString("type_transport"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public void updateValidity(Date dateEndContract, int id, Connection connection) {
        Contract contract = new Contract();
//        java.util.Date utilPackageDate
//                = contract.getDateEndContract();
//        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateEndContract);
        String query = """
                       UPDATE contract 
                       SET validity = ? WHERE id_contract = ?
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setDate(1, dateEndContract);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
