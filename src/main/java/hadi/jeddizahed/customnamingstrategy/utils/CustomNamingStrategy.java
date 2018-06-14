package hadi.jeddizahed.customnamingstrategy.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.stream.IntStream;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class CustomNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier!= null? jdbcEnvironment.getIdentifierHelper()
                .toIdentifier(convert(identifier.getText()), identifier.isQuoted()): new Identifier("",Boolean.TRUE);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier!= null? jdbcEnvironment.getIdentifierHelper()
                .toIdentifier(convert(identifier.getText()), identifier.isQuoted()): new Identifier("",Boolean.TRUE);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier!= null? jdbcEnvironment.getIdentifierHelper()
                .toIdentifier(convert(identifier.getText()), identifier.isQuoted()): new Identifier("",Boolean.TRUE);
    }

    private String convert(String name) {  
        for (int i=0; i< name.length();i++){
            char c =name.charAt(i);
            if (isUpperCase(c)) name = name.replace(String.valueOf(c), "_" + toLowerCase(c));
        }
        return name;
    }
}
