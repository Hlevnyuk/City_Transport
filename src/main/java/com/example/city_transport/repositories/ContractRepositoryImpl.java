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
                contract.setFilepath(rs.getString("filepath"));
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
                       INSERT INTO contract(firm, datee, validity, transport_count, type_transport, number_employee, filepath)
                       VALUES(?,?,?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, contract.getFirm());
            stmt.setDate(2, sqlDate);
            stmt.setDate(3, sqlDate1);
            stmt.setInt(4, contract.getTransportCount());
            stmt.setString(5, contract.getTypeTransport());
            stmt.setInt(6, contract.getNumberEmployee());
            stmt.setString(7, contract.getFilepath());
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
                contract.setFilepath(rs.getString("filepath"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public void updateValidity(Date dateEndContract, int id, Connection connection) {
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
    public int getLastValueId(Connection connection){
        String query = """
                       SELECT last_value FROM contract_id_contract_seq
                       """;
        int id = 0;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
