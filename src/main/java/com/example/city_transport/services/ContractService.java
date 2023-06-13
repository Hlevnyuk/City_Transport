package com.example.city_transport.services;
import com.example.city_transport.documentConvert.Doc;
import com.example.city_transport.models.Contract;
import com.example.city_transport.repositories.ContractRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepositoryImpl contractRepositoryImpl;
    private final Doc doc;
    public List<Contract> contractList(Connection connection){
        return contractRepositoryImpl.findAll(connection);
    }
    public Contract getById(int id, Connection connection){
        return contractRepositoryImpl.findById(id, connection);
    }
    public void deleteContract(int id, Connection connection){
        contractRepositoryImpl.deleteById(id, connection);
    }
    public void addContract(Contract contract, Connection connection) throws SQLException {
        contract.setId(contractRepositoryImpl.getLastValueId(connection) + 1);
//        String file = fileMethod(contract.getId());
//        System.out.println(contract.getId());
        contract.setFilepath(fileMethod(contract.getId()));
        doc.file(contract.getId(), contract.getTypeTransport(), contract.getTransportCount(), contract.getDateStartContract().toString(), contract.getDateEndContract().toString(), contract.getFirm());
        contractRepositoryImpl.save(contract, connection);
    }
    private String fileMethod(int id){
        String fileName = "contract" + id + ".docx";
        File newFile = new File("contracts/" + fileName);
        if(!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fileName;
    }
    public void updateContract(Date dateEndContract, int id, Connection connection){
        contractRepositoryImpl.updateValidity(dateEndContract, id, connection);
    }

}
