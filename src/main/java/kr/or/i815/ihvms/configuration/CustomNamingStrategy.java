package kr.or.i815.ihvms.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return reservedWord(name);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return reservedWord(name);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return reservedWord(convert(name));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return reservedWord(name);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return reservedWord(convert(name));
    }
    
    private Identifier convert(Identifier identifier) {
        if(identifier == null) {
            return null;
        }
        String name = identifier.getText();
        return Identifier.toIdentifier(camelToSnakeCase(name));
    }

    private String camelToSnakeCase(String camelcase) {
        return camelcase.replaceAll("([A-Z][a-z])", "_$1").toUpperCase();
    }

    private Identifier reservedWord(Identifier identifier) {
        if(identifier == null) {
            return null;
        }
        return Identifier.toIdentifier("`" + identifier.getText() + "`");
    }
}