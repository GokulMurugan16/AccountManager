package com.demo.account.manager.accountmanager.dao;

import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRQ;
import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRS;
import com.demo.account.manager.accountmanager.util.AppsConstants;
import com.demo.account.manager.accountmanager.util.CalendarUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountTransactionJDBCDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<AccountTransactionFilterRS> getAccountTransactionByFilterRQ(AccountTransactionFilterRQ filterRQ) throws ParseException {
        final List<AccountTransactionFilterRS> results = new ArrayList<>();

        Map<String, Object> filterParams = new HashMap<>();
        StringBuilder SQL = new StringBuilder();

        SQL.append("SELECT \n");
        SQL.append("  tat.ACCOUNT_TRANSACTION_ID, \n");
        SQL.append("  tat.ACCOUNT_ID, \n");
        SQL.append("  a.ACCOUNT_NUMBER, \n");
        SQL.append("  tat.TRANSACTION_DATE_TIME, \n");
        SQL.append("  tat.TRANSACTION_TYPE, \n");
        SQL.append("  tat.TRANSACTION_AMOUNT \n");
        SQL.append("FROM t_account_transaction tat \n");
        SQL.append("  LEFT JOIN t_account a ON tat.ACCOUNT_ID = a.ACCOUNT_ID \n");
        SQL.append("WHERE tat.ACCOUNT_TRANSACTION_ID IS NOT NULL \n");

        if (StringUtils.isNotEmpty(filterRQ.getAccountNumber())) {
            SQL.append("AND a.ACCOUNT_NUMBER = :accountNumber \n");
            filterParams.put("accountNumber", filterRQ.getAccountNumber());
        }

        if (filterRQ.getTransactionType() != null) {
            SQL.append("AND tat.TRANSACTION_TYPE = :transactionType \n");
            filterParams.put("transactionType", filterRQ.getTransactionType().toString());
        }

        if (StringUtils.isNotEmpty(filterRQ.getTransactionFromDateStr())) {
            SQL.append("AND tat.TRANSACTION_DATE_TIME >= :transactionFromDate \n");
            filterParams.put("transactionFromDate", CalendarUtil.getParsedDateTime(filterRQ.getTransactionFromDateStr()));
        }

        if (StringUtils.isNotEmpty(filterRQ.getTransactionToDateStr())) {
            SQL.append("AND tat.TRANSACTION_DATE_TIME <= :transactionToDate \n");
            filterParams.put("transactionToDate", CalendarUtil.getParsedDateTime(filterRQ.getTransactionToDateStr()));
        }

        SQL.append(" ORDER BY tat.TRANSACTION_DATE_TIME ");

        return this.namedParameterJdbcTemplate.query(SQL.toString(), filterParams, new ResultSetExtractor<List<AccountTransactionFilterRS>>() {
            @Override
            public List<AccountTransactionFilterRS> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    AccountTransactionFilterRS filterRS = new AccountTransactionFilterRS();

                    filterRS.setAccountTransactionID(rs.getInt("ACCOUNT_TRANSACTION_ID"));
                    filterRS.setAccountID(rs.getInt("ACCOUNT_ID"));
                    filterRS.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                    filterRS.setTransactionDateTimeStr(rs.getString("TRANSACTION_DATE_TIME"));
                    filterRS.setTransactionType(AppsConstants.TransactionType.valueOf(rs.getString("TRANSACTION_TYPE")));
                    filterRS.setTransactionAmount(rs.getBigDecimal("TRANSACTION_AMOUNT"));

                    results.add(filterRS);
                }
                return results;
            }
        });
    }
}
