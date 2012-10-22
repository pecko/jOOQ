/**
 * Copyright (c) 2009-2012, Lukas Eder, lukas.eder@gmail.com
 * All rights reserved.
 *
 * This software is licensed to you under the Apache License, Version 2.0
 * (the "License"); You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * . Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * . Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * . Neither the name "jOOQ" nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.jooq.test;

import java.util.List;

import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.conf.SettingsTools;
import org.jooq.util.mysql.MySQLFactory;


/**
 * @author Lukas Eder
 */
public class jOOQMySQLTestSchemaMapping extends jOOQMySQLTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();

        create().query("use " + TAuthor().getSchema().getName() + getSchemaSuffix()).execute();
    }

    @Override
    protected String getSchemaSuffix() {
        return "2";
    }

    @Override
    protected MySQLFactory create(Settings settings) {
        settings = (settings != null) ? settings : new Settings();
        RenderMapping mapping = SettingsTools.getRenderMapping(settings);
        List<MappedSchema> schemata = mapping.getSchemata();

        if (schemata.size() == 0) {
            schemata.add(new MappedSchema()
                .withInput(TAuthor().getSchema().getName())
                .withOutput(TAuthor().getSchema().getName() + getSchemaSuffix()));
        }
        else {
            schemata.get(0)
                .withInput(TAuthor().getSchema().getName())
                .withOutput(TAuthor().getSchema().getName() + getSchemaSuffix());
        }

        return new MySQLFactory(getConnection(), settings);
    }
}