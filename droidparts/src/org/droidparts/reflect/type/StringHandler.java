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
package org.droidparts.reflect.type;

import org.droidparts.reflect.util.TypeHelper;

import android.content.ContentValues;
import android.database.Cursor;

public class StringHandler extends TypeHandler<String> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isString(cls);
	}

	@Override
	public String getDBColumnType() {
		return TEXT;
	}

	@Override
	protected String parseFromString(Class<String> cls, String str) {
		return str;
	}

	@Override
	public void putToContentValues(ContentValues cv, String key, Object val) {
		cv.put(key, (String) val);
	}

	@Override
	public String readFromCursor(Class<String> cls, Cursor cursor,
			int columnIndex) {
		return cursor.getString(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<String> arrValType, String[] arr) {
		return arr;
	}

}
