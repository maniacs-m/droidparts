/**
 * Copyright 2013 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts;

import org.droidparts.inner.ConverterRegistry;
import org.droidparts.inner.converter.Converter;
import org.droidparts.persist.sql.AbstractDBOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class AbstractDependencyProvider {

	protected final Context ctx;

	public AbstractDependencyProvider(Context ctx) {
		this.ctx = ctx.getApplicationContext();
	}

	public final SQLiteDatabase getDB() {
		return getDBOpenHelper().getWritableDatabase();
	}

	public abstract AbstractDBOpenHelper getDBOpenHelper();

	protected final void addConverters(Converter<?>... converters) {
		for (Converter<?> converter : converters) {
			ConverterRegistry.addConverter(converter);
		}
	}

}
