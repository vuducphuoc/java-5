package com.laptrinhjava.Dao.Utils;


import java.util.Map;

public class HibernateUtil {

    public static Object[] buildNameQuery(Map<String, Object> property) {
        StringBuilder nameQuery = new StringBuilder();

        if (property != null && property.size() > 0) {

            String[] params = new String[property.size()];
            Object[] values = new Object[property.size()];

            int i = 0 ;

            for(Map.Entry item: property.entrySet()) {
                params[i] = (String) item.getKey();
                values[i] = item.getValue();
                i++;
            }

            for (int i1 = 0; i1 < params.length ; i1++) {
                nameQuery.append(" and ").append(" LOWER(" +params[i1]+ ") LIKE '%' || :"+params[i1]+" || '%' ");
            }

            return new Object[]{nameQuery, params, values};
        }
        return new Object[]{nameQuery.toString()};
    }
}
