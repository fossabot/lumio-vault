package com.lumiomedical.vault.legacy;

import com.lumiomedical.vault.Provides;
import com.lumiomedical.vault.Vault;
import com.lumiomedical.vault.exception.RuntimeVaultException;
import com.lumiomedical.vault.exception.VaultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PojoProvidedThroughModuleTest
{
    @Test
    public void pojoNotProvided()
    {
        Assertions.assertThrows(RuntimeVaultException.class, () -> {
            Vault vault = Vault.with();
            vault.instance(Pojo.class);
        });
    }

    @Test
    public void pojoProvided() throws VaultException
    {
        Vault vault = Vault.with(new Module());
        assertNotNull(vault.instance(Pojo.class));
    }

    public static class Module
    {
        @Provides
        Pojo pojo() {
            return new Pojo("foo");
        }
    }

    public static class Pojo
    {
        private final String foo;

        public Pojo(String foo) {
            this.foo = foo;
        }
    }
}
