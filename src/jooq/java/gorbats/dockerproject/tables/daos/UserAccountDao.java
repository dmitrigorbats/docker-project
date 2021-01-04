/*
 * This file is generated by jOOQ.
 */
package gorbats.dockerproject.tables.daos;


import gorbats.dockerproject.tables.UserAccount;
import gorbats.dockerproject.tables.records.UserAccountRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAccountDao extends DAOImpl<UserAccountRecord, gorbats.dockerproject.tables.pojos.UserAccount, Long> {

    /**
     * Create a new UserAccountDao without any configuration
     */
    public UserAccountDao() {
        super(UserAccount.USER_ACCOUNT, gorbats.dockerproject.tables.pojos.UserAccount.class);
    }

    /**
     * Create a new UserAccountDao with an attached configuration
     */
    public UserAccountDao(Configuration configuration) {
        super(UserAccount.USER_ACCOUNT, gorbats.dockerproject.tables.pojos.UserAccount.class, configuration);
    }

    @Override
    public Long getId(gorbats.dockerproject.tables.pojos.UserAccount object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<gorbats.dockerproject.tables.pojos.UserAccount> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(UserAccount.USER_ACCOUNT.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<gorbats.dockerproject.tables.pojos.UserAccount> fetchById(Long... values) {
        return fetch(UserAccount.USER_ACCOUNT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public gorbats.dockerproject.tables.pojos.UserAccount fetchOneById(Long value) {
        return fetchOne(UserAccount.USER_ACCOUNT.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<gorbats.dockerproject.tables.pojos.UserAccount> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(UserAccount.USER_ACCOUNT.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<gorbats.dockerproject.tables.pojos.UserAccount> fetchByName(String... values) {
        return fetch(UserAccount.USER_ACCOUNT.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public gorbats.dockerproject.tables.pojos.UserAccount fetchOneByName(String value) {
        return fetchOne(UserAccount.USER_ACCOUNT.NAME, value);
    }
}
