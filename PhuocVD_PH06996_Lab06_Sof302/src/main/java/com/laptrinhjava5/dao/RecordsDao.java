package com.laptrinhjava5.dao;

import com.laptrinhjava5.entity.Records;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public interface RecordsDao extends GenericDao<Integer, Records> {
}
