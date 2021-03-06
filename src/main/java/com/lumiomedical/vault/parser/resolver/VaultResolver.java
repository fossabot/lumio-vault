package com.lumiomedical.vault.parser.resolver;

import com.lumiomedical.vault.exception.VaultResolverException;
import com.lumiomedical.vault.parser.resolver.source.Source;

/**
 * @author Pierre Lecerf (pierre@noleme.com)
 * Created on 21/10/2018
 */
public interface VaultResolver
{
    /**
     *
     * @param origin
     * @return
     * @throws VaultResolverException
     */
    Source resolve(String origin) throws VaultResolverException;
}
