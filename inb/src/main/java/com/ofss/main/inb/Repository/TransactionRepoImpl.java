package com.ofss.main.inb.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// import com.ofss.main.domain.*;

public class TransactionRepoImpl implements TransactionRepo {
    final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";;
    private static final String password = "root";

    // connect to database
    private Connection connection = null;
    // store and execute query
    private PreparedStatement preparedStatement = null;
    // store result retrieved from database
    private ResultSet resultSet = null;

    private static final String INSERT_NEW_TRANSACTION = "INSERT INTO Transaction(payee_account_id, payer_account_id, transaction_amount, transaction_status, transaction_completed_at,transfer_type, transaction_type) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_ONE_PAYEE = "SELECT * FROM Account WHERE account_id= ?";
    private final String UPDATE_PAYEE_ACCOUNT = "UPDATE Account SET account_balance=? , overdraft_amount=? WHERE account_id = ?";

    @Override
    public String moneyTransaction(int payee_account_id, int payer_account_id, int transactionAmount, String transactionType) {

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            //GET PAYEE CUSTOMER
            preparedStatement = connection.prepareStatement(SELECT_ONE_PAYEE);
            preparedStatement.setInt(1, payee_account_id);
            resultSet = preparedStatement.executeQuery();
            int payee_new_balance =0;
            if(resultSet.next()){
                int balance = resultSet.getInt("account_balance");
                int min_balance = resultSet.getInt("account_minimum_balance");
                String account_type = resultSet.getString("account_type");
                int overdraft_amount = resultSet.getInt("overdraft_amount");
                int new_amount = transactionAmount;
                if(account_type.equalsIgnoreCase("savings")){
                    if(transactionAmount>0 && balance-transactionAmount >= min_balance){
                        payee_new_balance = balance - transactionAmount;
                    }else{
                        System.out.println("Transaction not possible beacause you dont have enough balance");
                        return null;
                    }
                }else{
                    if(transactionAmount>0 && transactionAmount<balance){
                        payee_new_balance = balance-transactionAmount;
                    }
                    else if(transactionAmount>0 && transactionAmount>balance && transactionAmount<balance+overdraft_amount){
                        new_amount=transactionAmount-balance;
                        payee_new_balance = 0;
                        overdraft_amount = overdraft_amount-new_amount;
                    }else{
                        System.out.println("Transaction not possible beacause you dont have enough balance");
                        return null;
                    }
                }
                //UPDATE PAYEE ACCOUNT
                preparedStatement = connection.prepareStatement(UPDATE_PAYEE_ACCOUNT);
                preparedStatement.setInt(1, payee_new_balance);
                preparedStatement.setInt(2, overdraft_amount);
                preparedStatement.setInt(3, payee_account_id);
                preparedStatement.execute();
            }
                
            //GET PAYER CUSTOMER
            preparedStatement = connection.prepareStatement(SELECT_ONE_PAYEE);
            preparedStatement.setInt(1, payer_account_id);
            resultSet = preparedStatement.executeQuery();
            int payer_new_balance = 0 ;
            
            if(resultSet.next()){
                int balance = resultSet.getInt("account_balance");
                String account_type = resultSet.getString("account_type");
                int payer_overdraft_amount = resultSet.getInt("overdraft_amount");
                int initial_overdraft_balance = payer_overdraft_amount;
                System.out.println("overdraft: "+initial_overdraft_balance);
                int new_amount = transactionAmount;
                System.out.println("new_amount"+transactionAmount);
                if(account_type.equalsIgnoreCase("savings")){
                        payer_new_balance = balance + transactionAmount;
                        System.out.println("balance: "+balance+" amount: "+transactionAmount+"payer balance is: "+payer_new_balance);
                }else{
                    if(transactionAmount>0 && initial_overdraft_balance>payer_overdraft_amount){
                        if(transactionAmount<(initial_overdraft_balance-payer_overdraft_amount)){
                            payer_overdraft_amount += transactionAmount;
                        }else{
                            new_amount = transactionAmount - initial_overdraft_balance - payer_overdraft_amount;
                            payer_overdraft_amount = initial_overdraft_balance;
                            payer_new_balance = balance + new_amount;
                        }
                    }else{
                        payer_new_balance = balance + transactionAmount;
                    }
                }
            

            //UPDATE PAYER ACCOUNT
            preparedStatement = connection.prepareStatement(UPDATE_PAYEE_ACCOUNT);
            preparedStatement.setInt(1, payer_new_balance);
            preparedStatement.setInt(2, payer_overdraft_amount);
            preparedStatement.setInt(3, payer_account_id);
            preparedStatement.execute();
        }
                            



            //INSERT TRANSACTION
            preparedStatement = connection.prepareStatement(INSERT_NEW_TRANSACTION);
            preparedStatement.setInt(1,payee_account_id);
            preparedStatement.setInt(2,payer_account_id);
            preparedStatement.setInt(3,transactionAmount);
            preparedStatement.setString(4,"Completed");
            preparedStatement.setString(5,"2024-07-18 10:51:19");
            preparedStatement.setString(6,transactionType);
            preparedStatement.setString(7,"debit");
            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                return "Transaction Successfull";
                
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
        return "Transaction Successfull";
    }

    
}
