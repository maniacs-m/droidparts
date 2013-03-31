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

import static org.droidparts.util.Arrays2.toPrimitive;

import java.util.ArrayList;

import org.droidparts.reflect.util.TypeHelper;

import android.content.ContentValues;
import android.database.Cursor;

public class DoubleHandler extends TypeHandler<Double> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isDouble(cls);
	}

	@Override
	public String getDBColumnType() {
		return REAL;
	}

	@Override
	protected Double parseFromString(Class<Double> cls, String str) {
		return Double.valueOf(str);
	}

	@Override
	public void putToContentValues(ContentValues cv, String key, Object val) {
		cv.put(key, (Double) val);
	}

	@Override
	public Double readFromCursor(Class<Double> cls, Cursor cursor,
			int columnIndex) {
		return cursor.getDouble(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<Double> arrValType, String[] arr) {
		ArrayList<Double> list = parseTypeColl(arrValType, arr);
		Double[] tArr = list.toArray(new Double[list.size()]);
		return (arrValType == double.class) ? toPrimitive(tArr) : tArr;
	}

}
